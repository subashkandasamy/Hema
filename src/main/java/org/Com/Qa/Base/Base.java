package org.Com.Qa.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author subash kandasamy
 *
 */
public class Base {

	public static Properties prop;
	public static String cwd = System.getProperty("user.dir");
	public static String testPageName;

	/**
	 * The constructor
	 */
	public Base() {

		initialize_properties();

	}

	/**
	 * The TheadLocal construct allows us to store data that will be accessible only
	 * by a specific thread.
	 */
	public static ThreadLocal<WebDriver> localdriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is used to initialize the webdriver
	 * 
	 * @param prop
	 * @return driver
	 */
	public WebDriver initialize_driver() {

		String browserName = prop.getProperty("browser");
		String proxyName = prop.getProperty("proxy");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().proxy(proxyName).setup();
			localdriver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().proxy(proxyName).setup();
			localdriver.set(new FirefoxDriver());

		} else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().proxy(proxyName).setup();
			localdriver.set(new InternetExplorerDriver());

		} else {
			System.out.println("Browser" + browserName
					+ "is not defined in properties file, please give the correct browser name");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Integer.valueOf(prop.getProperty("Implectwait")),
				TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(Integer.valueOf(prop.getProperty("Pagelodetimeout")),
				TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		return getDriver();

	}

	/**
	 * 
	 * The Method helps to Synchronized on the Class object associated with the
	 * class and since only one Class object exists per JVM per class
	 * 
	 * @return
	 */
	public synchronized static WebDriver getDriver() {
		return localdriver.get();
	}

	/**
	 * 
	 * The Method helps to initialize the config file properties
	 *
	 * @return
	 */
	public Properties initialize_properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(cwd + "/src/main/java/org/Com/Qa/Config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	/**
	 * 
	 * The Method helps to talk screen shot
	 * 
	 * @return
	 */
	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = cwd + "/Screenshot/Hema_" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

	/**
	 * 
	 * The Method helps to create an class instance when ever required
	 * 
	 * @param pageClass
	 * @return
	 */
	public <TPage extends Base> TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * The Method helps to quit the driver
	 * 
	 */
	public void quitBrowser() {
		try {
			getDriver().quit();
		} catch (Exception e) {
			System.out.println("some exception occurred while quitting the browser");
		}
	}

	/**
	 * 
	 * The Method helps to close the Browser
	 * 
	 */
	public void closeBrowser() {
		try {
			getDriver().close();
		} catch (Exception e) {
			System.out.println("some exception occurred while closing the browser");
		}
	}

}
