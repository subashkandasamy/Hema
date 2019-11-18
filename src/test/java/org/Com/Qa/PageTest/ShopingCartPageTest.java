package org.Com.Qa.PageTest;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Pages.ShopingCartPage;
import org.Com.Qa.Pages.SigninPage;
import org.Com.Qa.Utils.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShopingCartPageTest extends Base {

	SigninPage signinpage;
	ShopingCartPage shopingcartpage;
	String sheetName = "ShopingCart";

	public ShopingCartPageTest() {
		super();

	}

	@BeforeMethod
	public void testSetUp() {
		initialize_driver();
		signinpage = new SigninPage(getDriver());
		shopingcartpage = new ShopingCartPage(getDriver());
	}

	@DataProvider
	public Object[][] getShoppingCartData() {
		Object data[][] = ExcelUtils.getTestData(sheetName, "Data01");
		return data;
	}

	/**
	 * 
	 * @param product
	 * @param dataVarity login - search a product - add to cart - verify the cart
	 * 
	 */
	@Test(dataProvider = "getShoppingCartData", priority = 4)
	public void testSearchandAddProductToCart(String product, String dataVarity) {

		signinpage.simpleLoginIn();
		shopingcartpage.setProduct(product);
		shopingcartpage.clickSearchBtn();
		shopingcartpage.clickOnProductItem(product);
		shopingcartpage.clickOnAddToCart();
		shopingcartpage.clickOnViewBasket();
		Assert.assertTrue(shopingcartpage.verifyProductsInCart(product));
	}

	@AfterMethod
	public void teardown() {

		quitBrowser();
	}

}
