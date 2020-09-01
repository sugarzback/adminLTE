package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.admin.qa.base.TestBase;

public class UserPage extends TestBase{

	
	@FindBy(xpath="//h1[contains(text(),'Users')]")
	WebElement userPageLabel;
	
	@FindBy(xpath="//button[text()='Add User']")
	WebElement addUserBtn;
	
	@FindBy(xpath="//a[@href='users.html']")
	WebElement userLink;
	
	public UserPage() 
	{
		PageFactory.initElements(driver, this);
	}
	public UserPage clickOnUserLink()
	{
		userLink.click();
		return new UserPage();		
	}
	
	public String userPageTitleTest() 
	{
		return driver.getTitle();
	}
	
	public String userPageLabelTest()
	{
		return userPageLabel.getText();		
	}
	
	public boolean addUserBtnTest() 
	{
		return addUserBtn.isDisplayed();		
	}
	
	public AddUserPage clickOnAddUser()
	{
		addUserBtn.click();
		return new AddUserPage();
	}

}
