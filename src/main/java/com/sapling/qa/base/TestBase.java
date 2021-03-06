package com.sapling.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sapling.qa.util.TestUtil;
import com.sapling.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/sapling"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Chaitanya_Work\\Githubrepo\\Pageobjectmodule\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "D:\\Chaitanya_Work\\Githubrepo\\Pageobjectmodule\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("Opera")){
			OperaOptions options = new OperaOptions();
			options.setBinary("C:\\Users\\Dizerc1\\AppData\\Local\\Programs\\Opera\\56.0.3051.116\\opera.exe");
			driver = new OperaDriver(options);
					}
		else if(browserName.equals("IE")){
			InternetExplorerOptions options = new InternetExplorerOptions();
			options.requireWindowFocus();
			driver = new InternetExplorerDriver(options);	
		}
			
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
