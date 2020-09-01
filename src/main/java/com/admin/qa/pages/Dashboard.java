package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;

public class Dashboard extends TestBase{

	
	@FindBy(className="logo-lg")
	WebElement logo;
	
	@FindBy(xpath="//a[@href='users.html']")
	WebElement userLink;
	
	@FindBy(xpath="//a[@href='operators.html']")
	WebElement operatorLink;
	
	@FindBy(xpath="/html/body/div/aside[1]/section/ul/li[5]/a")
	WebElement logoutLink;
	
	@FindBy(xpath="/html/body/div[1]/header/nav/div/ul/li/a")
	WebElement logout;
	
	@FindBy(xpath="/html/body/div/div[1]/section[1]/h1")
	WebElement heading;
	
	@FindBy(xpath="//div//p[text()='Kiran']")
	WebElement loggedUser;
	
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	WebElement dashboardPageLabel;
	
	public Dashboard() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle() {
		return driver.getTitle();
	}
	
	public boolean loggedUserTest()
	{
		return loggedUser.isDisplayed();		
	}
	
	public String dashboardPageLabelTest() 
	{
		return dashboardPageLabel.getText();		
	}
	
	public UserPage clickOnUserLink()
	{
		userLink.click();
		return new UserPage();		
	}
	
	public OperatorPage clickOnOperatorLink()
	{
		operatorLink.click();
		return new OperatorPage();		
	}
	
	
	public LogoutPage verifylogout() {
		logout.click();
		return new LogoutPage();
	}
	
}
