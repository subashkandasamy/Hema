package org.Com.Qa.Pages;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author subash Kandasamy
 *
 */
public class SigninPage extends Base {

	WebDriver driver;

	// Object Repository

	@FindBy(xpath = "//a[contains(text(),'sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='dwfrm_preregister_username_default']")
	WebElement registerEmail;

	@FindBy(xpath = "//span[@id='dwfrm_preregister_username_default-error']")
	WebElement registerEmailErrMsg;

	@FindBy(xpath = "//strong[contains(text(),'This email address already exist')]")
	WebElement regEmailAlreadyErrMsg;

	@FindBy(xpath = "//button[@name='dwfrm_preregister_register']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@id='dwfrm_login_username_default']")
	WebElement loginEmail;

	@FindBy(xpath = "//input[@id='dwfrm_login_password_default']")
	WebElement passWord;

	@FindBy(xpath = "//input[@name='dwfrm_login_login']")
	WebElement loginBtn;

	@FindBy(xpath = "//strong[contains(text(),\"Sorry we don't recognise your details.\")]")
	WebElement loginMainErrMsg;

	@FindBy(xpath = "//li[contains(text(),'Your email address or password is incorrect.')]")
	WebElement loginSpecficErrMsg;

	/**
	 * @param driver
	 */
	public SigninPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * 
	 * Method will click on sign in button
	 * 
	 */
	public void clickSignInBtn() {

		signInBtn.click();
	}

	/**
	 * 
	 * Method will set the Emailid
	 * 
	 * @param email
	 * 
	 */
	public void setRegEmailId(String email) {

		registerEmail.clear();
		registerEmail.sendKeys(email);
	}

	/**
	 * 
	 * Method will clear the Emailid
	 * 
	 */
	public void clearRegEmailId() {

		registerEmail.clear();
	}

	/**
	 * 
	 * Method will click on continue button
	 *
	 */
	public void clickContinuBtn() {

		TimeUtils.SamllWait();
		continueBtn.click();

	}

	/**
	 * 
	 * Method will set the login Emailid
	 * 
	 * @param emailid
	 * 
	 */
	public void setLoginEmailId(String emailid) {
		loginEmail.clear();
		loginEmail.sendKeys(emailid);
	}

	/**
	 * 
	 * Method will set the login Password
	 * 
	 * @param ipassword
	 * 
	 */
	public void setLoginPassword(String ipassword) {

		passWord.clear();
		passWord.sendKeys(ipassword);
	}

	/**
	 * 
	 * Method will click on login button
	 * 
	 */
	public void clickLoginBtn() {

		loginBtn.click();

	}

	/**
	 * 
	 * Method will get the register error message
	 * 
	 * @return
	 * 
	 */
	public String getRegisterErrMsg() {

		return registerEmailErrMsg.getText();

	}

	/**
	 * 
	 * Method will get the Login error message
	 * 
	 * @return
	 * 
	 */
	public boolean getLoginErrMsg() {

		return loginMainErrMsg.isDisplayed();

	}

	/**
	 * 
	 * Method will get the register field level message *
	 * 
	 * @return
	 * 
	 */
	public boolean getLoginSpecficErrMsg() {

		return loginSpecficErrMsg.isDisplayed();

	}

	/**
	 * 
	 * Method will get the register error message
	 * 
	 * @return
	 */
	public boolean verfiyRegErrMsg() {

		return regEmailAlreadyErrMsg.isDisplayed();

	}

	/**
	 * 
	 * Method help to login to application
	 * 
	 */
	public void simpleLoginIn() {

		clickSignInBtn();
		setLoginEmailId(prop.getProperty("username"));
		setLoginPassword(prop.getProperty("password"));
		clickLoginBtn();
	}
	

	
	public void simplelogOut() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[@class='btn grey dropdown profile-btn']"))).perform();
		actions.moveToElement(driver.findElement(By.linkText("sign out"))).perform();

	}

}
