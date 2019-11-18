package org.Com.Qa.Pages;

import org.Com.Qa.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDetailsPage extends Base {

	WebDriver driver;

	// Object Repository

	@FindBy(xpath = "//a[@class='btn grey dropdown profile-btn']")
	WebElement myDetailsPage;

	public MyDetailsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * Method will verify the email is in my details page
	 * 
	 * @param email
	 * @return
	 */
	public boolean verifyEmailId(String email) {

		return driver.findElement(By.xpath("//p[contains(text(),'" + email + "')]")).isDisplayed();

	}

	/**
	 * method will click on my details link
	 */
	public void clickOnDetailsLink() {

		myDetailsPage.click();

	}

}
