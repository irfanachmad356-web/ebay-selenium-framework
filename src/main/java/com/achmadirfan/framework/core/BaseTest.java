package com.achmadirfan.framework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.achmadirfan.framework.pages.CategoryPage;

public class BaseTest {

	public WebDriver driver;
	public CategoryPage category;
	private Properties prop;
	
	/**
	 * This method centralizes the creation and configuration of WebDriver.
	 * Keeping driver setup in one place ensures consistency and prevents setup duplication
	 * across multiple test classes.
	 */
	
	public WebDriver initializeDriver() throws IOException {
		
	prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
			+"//src//main//java//com//achmadirfan//framework//config//GlobalData.properties");
	prop.load(fis);
	
	String browserName = System.getProperty("browser") != null
	        ? System.getProperty("browser")
	        : prop.getProperty("browser");

	browserName = browserName.toLowerCase();
	
	switch (browserName) {
    case "chrome":
        driver = new ChromeDriver();
        break;

    case "firefox":
        driver = new FirefoxDriver();
        break;

    case "edge":
        driver = new EdgeDriver();
        break;

    default:
        throw new RuntimeException("Browser not supported: " + browserName);
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	/**
	 * Runs before every test method to guarantee each test starts
	 * with a fresh browser state. This prevents cross-test contamination.
	 *
	 * Returning the CategoryPage ensures test classes can immediately
	 * access page-level actions without manual instantiation.
	 */
	
	@BeforeMethod
	public CategoryPage startApplication() throws IOException {
		
		driver = initializeDriver();
		//lp = new LandingPage(driver);
		category = new CategoryPage(driver);
		category.goTo();;
		//lp.goTo();
		return category;
	}
	
	 /**
	 * Ensures browser instances are properly closed after each test.
	 * Prevents resource leaks and ensures the machine running the tests
	 * does not accumulate zombie WebDriver processes.
	 */
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";
	}
	
	
}
