package com.orangeHRM.genericLibrary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.orangeHRM.elementRepository.DashboardPage;
import com.orangeHRM.elementRepository.LoginPage;


/**
 * This class is used to common activities of all scripts in the form of annotation
 * This is the superMost class of all scripts 
 * @author Niraj
 */
public class BaseClass  {
	public String username;
	public String password;
	public String browser;
	public WebDriver driver;
	public long longTimeOut;
	public int randomNumber;
	public String randomString;
	public Logger logger; 
	public LoginPage loginPage;
	public DashboardPage dashboardPage;
	public JavaUtility javaUtility ;
	public ExcelFileUtility excelFileUtility;
	public PropertyFileUtility propertyFileUtility;

	/**
	 * This annotation is used to open the property file and excel file
	 * @throws IOException
	 */
	@BeforeSuite
	public void beforeSuiteTest() {
		propertyFileUtility = new PropertyFileUtility();
		excelFileUtility = new ExcelFileUtility();
		propertyFileUtility.openPropertyFile(IconstantPathUtility.PROPERTYFILEPATH);
		excelFileUtility.openExcelFile(IconstantPathUtility.EXCELFILEPATH);
	}
	/**
	 * This annotation is used to fetch the data from property file
	 * create the instance for all utilities
	 * 
	 */
	@BeforeClass
	public void beforeClassTest() {
		try {
			logger = LogManager.getLogger(this.getClass());

			String url = propertyFileUtility.getDataFromPropertyFile("url");
			System.out.println("Url : " + url);
			username = propertyFileUtility.getDataFromPropertyFile("UserName");
			System.out.println("UserName : " + username);
			password = propertyFileUtility.getDataFromPropertyFile("Password");
			System.out.println("Password : " + password);
			String timeout = propertyFileUtility.getDataFromPropertyFile("Timeout");
			System.out.println("TimeOut : " + timeout);
			String  browser = propertyFileUtility.getDataFromPropertyFile("Browser");
			System.out.println("Browser : " + browser);

			//			longTimeOut=javaUtility.stringConvertToLong(timeout);
			//			randomNumber = javaUtility.generateRandomNum(100);
			longTimeOut = WebDriverUtility.getInstance().javaUtility.stringConvertToLong(timeout);
			randomNumber = WebDriverUtility.getInstance().javaUtility.generateRandomNum(100);
			randomString = WebDriverUtility.getInstance().javaUtility.generateRandomString(3);

			switch(browser) {
			case "chrome":

//				WebDriverManager.chromedriver().setup();
//				ChromeOptions options = new ChromeOptions();
//				options.addArguments("--headless=new");
//				options.addArguments("disable-infobars");
//				driver = new ChromeDriver(options);
				driver = new ChromeDriver();
				break;

			case "firefox":
//				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":
//				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				System.out.println("please specify proper browser key");
//				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			WebDriverUtility.getInstance().config(longTimeOut, driver, url);
			//			deleteAllCookies(driver);
			//			browserSetting(longTimeOut, driver);
			//			explicitlyWait(driver, longTimeOut);
			//			initializeJavaScriptExecutor(driver);
			//			initializeAction(driver);

			loginPage = new LoginPage(driver);
			PageFactory.initElements(driver, loginPage);
			dashboardPage = new DashboardPage(driver);
			//			navigateApp(url, driver);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This annotation is used to login the application
	 */
	@BeforeMethod
	public void beforeMethodTest() {
		loginPage.loginAction(username, password);
	}
	/**
	 * This annotation is used to logout the application 
	 * @throws InterruptedException 
	 */
	@AfterMethod
	public void afterMethodTest() {
		//		dashboardPage.clickLogoutButton(driver);
	}
	/**
	 * This annotation is used to close the browser
	 */
	@AfterClass
	public void afterClassTest()
	{
		driver.quit();
	}
	@AfterSuite
	public void afterSuiteTest() {

	}
}
