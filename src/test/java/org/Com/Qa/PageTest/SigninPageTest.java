package org.Com.Qa.PageTest;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Pages.MyDetailsPage;
import org.Com.Qa.Pages.RegisterPage;
import org.Com.Qa.Pages.SigninPage;
import org.Com.Qa.Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SigninPageTest extends Base {

	RegisterPage registerpage;
	SigninPage signinpage;
	MyDetailsPage mydetailspage;
	String sheetName = "Signin";

	/**
	 * Constructor
	 */
	public SigninPageTest() {
		super();

	}

	@BeforeMethod
	public void testSetUp() {

		initialize_driver();
		registerpage = new RegisterPage(getDriver());
		signinpage = new SigninPage(getDriver());
		mydetailspage = new MyDetailsPage(getDriver());

	}

	/**
	 * 
	 * Test will verify all Negative field level validation
	 * 
	 */
	@Test(priority = 1)
	public void testLoginNegetiveCases() {

		signinpage.clickSignInBtn();

		signinpage.clickLoginBtn();
		Assert.assertTrue(signinpage.getLoginErrMsg());

		signinpage.setLoginEmailId("mgr@emailid.com");
		signinpage.setLoginPassword("123");
		signinpage.clickLoginBtn();
		Assert.assertTrue(signinpage.getLoginSpecficErrMsg());

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] = ExcelUtils.getTestData(sheetName, "Data01");
		return data;
	}

	/**
	 * @param email
	 * @param password
	 * @param datavarity
	 * 
	 *                   Test will successfully login and verify the email id in my
	 *                   details page
	 * 
	 */
	@Test(dataProvider = "getLoginData" , priority = 2)
	public void testLogin(String email, String password, String datavarity) {

		signinpage.clickSignInBtn();
		signinpage.setLoginEmailId(email);
		signinpage.setLoginPassword(password);
		signinpage.clickLoginBtn();
		mydetailspage.clickOnDetailsLink();
		Assert.assertTrue(mydetailspage.verifyEmailId(email));

	}
	
	
	/**
	 * 
	 * Test will verify the sign out from application 
	 * 
	 */
	@Test()
	public void testSignOut() {
		
		signinpage.simpleLoginIn();
		signinpage.simplelogOut();
		
	}
	

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
