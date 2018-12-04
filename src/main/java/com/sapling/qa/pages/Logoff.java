package com.sapling.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sapling.qa.base.TestBase;

public class Logoff extends TestBase{
	WebDriverWait wait=new WebDriverWait(driver, 20);
	
	//Page Factory - OR:
	@FindBy(xpath="//md-menu-bar[@id='user-menu']//button[@type='button']")
	WebElement user;
	
	@FindBy(xpath="/html[1]/body[1]/div[5]/md-menu-content[1]/md-menu-item[1]/button[1]")
	WebElement Myupdates;
	
	@FindBy(xpath="/html[1]/body[1]/div[5]/md-menu-content[1]/md-menu-item[3]/button[1]")
	WebElement Settings;
	
/*	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	*/
	@FindBy(xpath="/html[1]/body[1]/div[5]/md-menu-content[1]/md-menu-item[4]/button[1]")
	WebElement Signout;
	
	//Initializing the Page Objects:
	public Logoff(){
		PageFactory.initElements(driver, this);
	}
	public LoginPage signoff(){
		wait.until(ExpectedConditions.visibilityOf(user));
			user.click();
		wait.until(ExpectedConditions.visibilityOf(Signout));
			Signout.click();
		return new LoginPage();
	}
	
}
