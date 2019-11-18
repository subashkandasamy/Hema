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

public class RegisterPageTest extends Base {

	RegisterPage registerpage;
	SigninPage signinpage;
	MyDetailsPage mydetailspage;
	String sheetName = "Register";

	/**
	 * Constructor
	 */
	public RegisterPageTest() {
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
	 * test will verify the sign in page user creation
	 * 
	 */
	@Test(priority = 1)
	public void testSignInRegisterNewUserNegtiveCases() {

		signinpage.clickSignInBtn();

		signinpage.clearRegEmailId();
		signinpage.setRegEmailId("mgr@emailid.com");
		signinpage.clickContinuBtn();
		Assert.assertTrue(signinpage.verfiyRegErrMsg());

		signinpage.clearRegEmailId();
		signinpage.clickContinuBtn();
		Assert.assertEquals(signinpage.getRegisterErrMsg(), "enter a valid value");

		signinpage.setRegEmailId("jilljill1234");
		signinpage.clickContinuBtn();
		Assert.assertEquals(signinpage.getRegisterErrMsg(), "e-mail address is not valid");

	}

	@DataProvider
	public Object[][] getCreateUserData() {
		Object data[][] = ExcelUtils.getTestData(sheetName, "Data01");
		return data;
	}

	/**
	 * @param email
	 * @param gender
	 * @param firstName
	 * @param LastName
	 * @param dataofBirth
	 * @param companyName
	 * @param address
	 * @param postCode
	 * @param city
	 * @param Password
	 * @param confirmPassword
	 * @param message
	 * @param DataVarlity
	 * 
	 *                        test will verify the user creation
	 * 
	 */
	@Test(dataProvider = "getCreateUserData", priority = 4)
	public void testCreateNewUser(String email, String gender, String firstName, String LastName, String dataofBirth,
			String companyName, String address, String postCode, String city, String Password, String confirmPassword,
			String message, String DataVarlity

	) {

		signinpage.clickSignInBtn();
		signinpage.setRegEmailId(email);
		signinpage.clickContinuBtn();
		registerpage.setGender(gender);
		registerpage.setFirstName(firstName);
		registerpage.setLastName(LastName);
		registerpage.setDataOfBirth(dataofBirth);
		registerpage.setCompany(companyName);
		registerpage.setAddress(address);
		registerpage.setPostalCode(postCode);
		registerpage.setCity(city);
		registerpage.setPassword(Password);
		registerpage.setPasswordconfirm(confirmPassword);
		registerpage.clinkContinueBtn();
		Assert.assertTrue(mydetailspage.verifyEmailId(email));
	}

	@DataProvider
	public Object[][] getIncorrectPwdData() {
		Object data[][] = ExcelUtils.getTestData(sheetName, "Data02");
		return data;
	}

	/**
	 * @param email
	 * @param gender
	 * @param firstName
	 * @param LastName
	 * @param dataofBirth
	 * @param companyName
	 * @param address
	 * @param postCode
	 * @param city
	 * @param Password
	 * @param confirmPassword
	 * @param message
	 * @param DataVarlity
	 * 
	 *                        test will verify the incorrect password
	 * 
	 */
	@Test(dataProvider = "getIncorrectPwdData", priority = 3)
	public void testMissMatchPassword(String email, String gender, String firstName, String LastName,
			String dataofBirth, String companyName, String address, String postCode, String city, String Password,
			String confirmPassword, String message, String DataVarlity

	) {

		signinpage.clickSignInBtn();
		signinpage.setRegEmailId(email);
		signinpage.clickContinuBtn();
		registerpage.setGender(gender);
		registerpage.setFirstName(firstName);
		registerpage.setLastName(LastName);
		registerpage.setDataOfBirth(dataofBirth);
		registerpage.setCompany(companyName);
		registerpage.setAddress(address);
		registerpage.setPostalCode(postCode);
		registerpage.setCity(city);
		registerpage.setPassword(Password);
		registerpage.setPasswordconfirm(confirmPassword);
		registerpage.clinkContinueBtn();
		Assert.assertEquals(registerpage.getpasswordConfrmErr(), message);

	}

	/**
	 * 
	 * test will verify the field level validation of register page
	 * 
	 */
	@Test(priority = 2)
	public void testRegisterNewUserNegetiveCases() {

		String errorMessage = "enter a valid value";
		signinpage.clickSignInBtn();
		signinpage.setRegEmailId("mgr3@emailid.com");
		signinpage.clickContinuBtn();
		registerpage.clinkContinueBtn();
		Assert.assertEquals(registerpage.getGenderErr(), errorMessage);
		Assert.assertEquals(registerpage.getNameErr(), errorMessage);
		Assert.assertEquals(registerpage.getAddressErr(), errorMessage);
		Assert.assertEquals(registerpage.getPostCodeErr(), errorMessage);
		Assert.assertEquals(registerpage.getCityErr(), errorMessage);
		Assert.assertEquals(registerpage.getpasswordErr(), errorMessage);
		Assert.assertEquals(registerpage.getpasswordConfrmErr(), errorMessage);

	}

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
