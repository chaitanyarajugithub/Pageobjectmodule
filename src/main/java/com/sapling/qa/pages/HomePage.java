package com.sapling.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sapling.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//span[@class='username md-subhead secondary-text login_username ng-binding']")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath = "//ul[@class='ng-scope']//li[4]//div[1]//a[1]")
	WebElement Profilesetup;
	
	@FindBy(xpath = "//ul[@class='ng-scope']//li[3]//div[1]//a[1]")
	WebElement Emailsetup;
	

	@FindBy(xpath = "//ul[@class='ng-scope']//li[5]//div[1]//a[1]")
	WebElement Timeoff;

	@FindBy(xpath = "//ul[@class='ng-scope']//li[6]//div[1]//a[1]")
	WebElement Permissions;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public Profilesetuppage clickOnProfilesetup(){
		Profilesetup.click();
		return new Profilesetuppage();
	}
	
	public Emailsetuppage clickOnEmailLink(){
		Emailsetup.click();
		return new Emailsetuppage();
	}
	
	public Timeoffpage clickOnTimeoffLink(){
		Timeoff.click();
		return new Timeoffpage();
	}
	public Permissionspage clickOnPermissionsLink(){
		Permissions.click();
		return new Permissionspage();
	}
	
	
	/*public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}*/
	
}
