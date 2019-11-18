package org.Com.Qa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	/**
	 * Object Repository
	 */

	@FindBy(xpath = "//div[@class='wrap']//div//a[@class='logo']//img")
	WebElement hemaLogo;

	/**
	 * @param driver
	 */
	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * Method will verify the logo
	 * 
	 * @return
	 */
	public Boolean verifyLogo() {

		return hemaLogo.isDisplayed();
	}

	/**
	 * 
	 * Method will return the title
	 * 
	 * @return
	 */
	public String getTitle() {

		return driver.getTitle();
	}

}
