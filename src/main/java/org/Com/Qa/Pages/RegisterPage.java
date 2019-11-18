package org.Com.Qa.Pages;

import org.Com.Qa.Base.Base;
import org.Com.Qa.Utils.TimeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author subash kandasamy
 *
 */
public class RegisterPage extends Base {

	WebDriver driver;

	// Object Repository
	@FindBy(xpath = "//span[@id='dwfrm_profile_customer_gender-error']")
	WebElement genderErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_name_firstname_GB']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_name_lastname_GB']")
	WebElement lastName;

	@FindBy(xpath = "//span[@id='dwfrm_profile_customer_name_lastname_GB-error']")
	WebElement nameErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_birthday_GB']")
	WebElement dateOfBirth;

	@FindBy(xpath = "//input[@id='dwfrm_profile_address_company_GB']")
	WebElement company;

	@FindBy(xpath = "//input[@id='dwfrm_profile_address_address1_GB']")
	WebElement address;

	@FindBy(xpath = "//span[@id='dwfrm_profile_address_address1_GB-error']")
	WebElement addressErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_address_postal_GB']")
	WebElement postalCode;

	@FindBy(xpath = "//span[@id='dwfrm_profile_address_postal_GB-error']")
	WebElement postalCodeErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_address_city_GB']")
	WebElement city;

	@FindBy(xpath = "//span[@id='dwfrm_profile_address_city_GB-error']")
	WebElement cityErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_login_password_GB']")
	WebElement passWord;

	@FindBy(xpath = "//span[@id='dwfrm_profile_login_password_GB-error']")
	WebElement passWordErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_login_passwordconfirm_GB']")
	WebElement passWordConfirm;

	@FindBy(xpath = "//span[@id='dwfrm_profile_login_passwordconfirm_GB-error']")
	WebElement passWordConfirmErrMsg;

	@FindBy(xpath = "//input[@id='dwfrm_profile_customer_birthday_GB']")
	WebElement genericErrorMessage;

	@FindBy(xpath = "//button[@name='dwfrm_profile_confirm']")
	WebElement continueBtn;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/**
	 * method will get the gender error
	 * 
	 * @return
	 */
	public String getGenderErr() {
		return genderErrMsg.getText();

	}

	/**
	 * method will set the gender
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		
		TimeUtils.SamllWait();
		driver.findElement(By.xpath("//label[contains(text(),'" + gender + ".')]")).click();

	}

	/**
	 * method will get the name error
	 * 
	 * @return
	 */
	public String getNameErr() {

		return nameErrMsg.getText();

	}

	/**
	 * method will set the first name
	 * 
	 * @param ifirstName
	 */
	public void setFirstName(String ifirstName) {

		firstName.clear();
		firstName.sendKeys(ifirstName);

	}

	/**
	 * method will set the lastName
	 * 
	 * @param iLastName
	 */
	public void setLastName(String iLastName) {

		lastName.clear();
		lastName.sendKeys(iLastName);

	}

	/**
	 * method will set the Bday
	 * 
	 * @param idataofBirth
	 */
	public void setDataOfBirth(String idataofBirth) {

		dateOfBirth.clear();
		dateOfBirth.sendKeys(idataofBirth);
	}

	/**
	 * method will set the company
	 * 
	 * @param companyName
	 */
	public void setCompany(String companyName) {
		company.clear();
		company.sendKeys(companyName);

	}

	/**
	 * method will set the Address
	 * 
	 * @param iAddress
	 */
	public void setAddress(String iAddress) {

		address.clear();
		address.sendKeys(iAddress);

	}

	/**
	 * method will get the Address error
	 * 
	 * @return
	 */
	public String getAddressErr() {

		return addressErrMsg.getText();

	}

	/**
	 * method will set the postcode
	 * 
	 * @param ipostCode
	 */
	public void setPostalCode(String ipostCode) {

		postalCode.clear();
		postalCode.sendKeys(ipostCode);
		;

	}

	/**
	 * method will get the postcode error
	 * 
	 * @return
	 */
	public String getPostCodeErr() {

		return postalCodeErrMsg.getText();

	}

	/**
	 * method will set the city
	 * 
	 * @param iCity
	 */
	public void setCity(String iCity) {

		city.clear();
		city.sendKeys(iCity);
		;

	}

	/**
	 * method will get the city error
	 * 
	 * @return
	 */
	public String getCityErr() {

		return cityErrMsg.getText();

	}

	/**
	 * 
	 * method will set the Password
	 * 
	 * @param ipassword
	 */
	public void setPassword(String iPassword) {

		passWord.clear();
		passWord.sendKeys(iPassword);
		;

	}

	/**
	 * method will get the Password error
	 * 
	 * @return
	 */
	public String getpasswordErr() {

		return passWordErrMsg.getText();

	}

	/**
	 * method will set the Confirmation Password
	 * 
	 * @param iPasswordConfirm
	 */
	public void setPasswordconfirm(String iPasswordConfirm) {

		passWordConfirm.clear();
		passWordConfirm.sendKeys(iPasswordConfirm);
		;

	}

	/**
	 * method will get the Confirmation Password error
	 * 
	 * @return
	 */
	public String getpasswordConfrmErr() {

		return passWordConfirmErrMsg.getText();

	}

	/**
	 * method will click on continue button
	 */
	public void clinkContinueBtn() {

		continueBtn.click();

	}

	/**
	 * method will get the generic error messages
	 * 
	 * @return
	 */
	public String getGenericErrMsg() {

		return genderErrMsg.getText();

	}

}
