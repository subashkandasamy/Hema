package org.Com.Qa.Pages;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCartPage extends Base {

	WebDriver driver;

	// Object Repository
	@FindBy(xpath = "//input[@id='q']")
	WebElement searchProduct;

	@FindBy(xpath = "//div[@class='inner']//i[@class='ico ico-search']")
	WebElement searchBtn;

	@FindBy(xpath = "//div[@class='btns-wrap row']//button[@id='add-to-cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//a[@class='btn gold large checkout-btn']")
	WebElement viewBasketBtn;

	@FindBy(xpath = "//div[@class='product-info']//h3")
	WebElement productInfo;

	public ShopingCartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * @param product enter the product in search bar
	 */
	public void setProduct(String product) {

		searchProduct.sendKeys(product);
	}

	/**
	 * click on search button
	 * 
	 */
	public void clickSearchBtn() {

		searchBtn.click();
		TimeUtils.longWait();

	}

	/**
	 * @param product click on item in list
	 */
	public void clickOnProductItem(String product) {

		TimeUtils.mediumWait();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		TimeUtils.SamllWait();
		productInfo.click();
	}

	/**
	 * click on add to cart button
	 */
	public void clickOnAddToCart() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		addToCartBtn.click();
		TimeUtils.SamllWait();
	}

	/**
	 * click on view Basket
	 */
	public void clickOnViewBasket() {

		TimeUtils.SamllWait();
		viewBasketBtn.click();
	}

	/**
	 * verify the product in view Basket
	 */
	public boolean verifyProductsInCart(String product) {

		TimeUtils.SamllWait();
		return driver.findElement(By.xpath(
				"//div[@class='padding-wrap basket-item js-cart-product-item']//a[contains(text(),'" + product + "')]"))
				.isDisplayed();

	}

}
