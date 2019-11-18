package org.Com.Qa.Utils;

import org.Com.Qa.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementActions extends Base {
	
	WebDriver driver;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method is used to create the webelement on the basis of given By locator
	 * 
	 * @param locator
	 * @return webelement
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " + locator);
		}
		return element;
	}

	/**
	 * this method is used to wait fot the element to be present
	 * 
	 * @param locator
	 */
	public void waitForElementPresent(By locator, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	/**
	 * this method is used to wait fot the element to be present
	 * 
	 * @param locator
	 */
	public void waitForElementVisiable(By locator,long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	

	/**
	 * 
	 * @param title
	 */
	public void waitForTitlePresent(String title ,long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * This method is used to check element is displayed or not
	 * 
	 * @param locator
	 * @return
	 */
	public boolean elementIsDisplayed(By locator,long timeOutInSeconds) {
		waitForElementPresent(locator,timeOutInSeconds);
		return getElement(locator).isDisplayed();
	}

	/**
	 * this method is used to click on an element
	 * 
	 * @param locator
	 */
	public void elementClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * this method is used to pass the values
	 * 
	 * @param locator
	 * @param value
	 */
	public void elementSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * 
	 * @return
	 */
	public String getPageTitle() {
		String title = null;
		try {
			title = driver.getTitle();
		} catch (Exception e) {
			System.out.println("some exception occurred while getting the title " + title);
		}
		return title;
	}
	
	public void WaitForElement(WebElement element,long timeOutInSeconds){		
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	
	}
	
	
	
	
	
}
