package com.sapling.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapling.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"login-form\"]/form/button")
	WebElement loginBtn;
	
/*	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	*/
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/md-content[1]/div[1]/div[1]/div[1]/div[1]/img[1]")
	WebElement saplingLogo;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatesaplinglogo(){
		return saplingLogo.isDisplayed();
	}
	
	public HomePage login(String usr, String pwd){
		username.sendKeys(usr);
		password.sendKeys(pwd);
		//loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
	 	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);    	
		return new HomePage();
	}
	
}
