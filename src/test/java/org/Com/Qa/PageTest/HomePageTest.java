package org.Com.Qa.PageTest;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

	HomePage homepage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void testSetUp() {
		initialize_driver();
		homepage = new HomePage(getDriver());
	}

	/**
	 * test will very the logo
	 */
	@Test(priority = 1)
	public void testlogo() {

		Assert.assertTrue(homepage.verifyLogo());
	}

	/**
	 * test will very the title
	 */
	@Test(priority = 1)
	public void testTitle() {

		Assert.assertEquals(homepage.getTitle(), "HEMA | original design | surprisingly low prices");
	}

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
