package com.sapling.qa.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sapling.qa.base.TestBase;
import com.sapling.qa.pages.Profilesetuppage;
import com.sapling.qa.pages.HomePage;
import com.sapling.qa.pages.LoginPage;
import com.sapling.qa.pages.Logoff;
import com.sapling.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	Logoff logoff;
	HomePage homePage;
	TestUtil testUtil;
	Profilesetuppage profilesetuppage;

	public HomePageTest() {
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		profilesetuppage = new Profilesetuppage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1,enabled = true)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Reporter.log(homePageTitle,true);
		Assert.assertEquals(homePageTitle, "Sapling HR","Home page title not matched");
	}
	
	@Test(priority=2,enabled = true)
	public void verifysignoff() {
		logoff = new Logoff();
		loginPage = logoff.signoff();
		
	}
	@Test(priority=3,enabled = false)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=4,enabled = false)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		profilesetuppage = homePage.clickOnProfilesetup();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
