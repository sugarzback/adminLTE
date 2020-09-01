package com.admin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.AddUserPage;
import com.admin.qa.pages.Dashboard;
import com.admin.qa.pages.LoginPage;
import com.admin.qa.pages.UserPage;

public class UserPageTest extends TestBase{

	LoginPage loginPage;
	Dashboard dashboard;
	UserPage userpage;
	AddUserPage addUserPage;
	
	public UserPageTest() 
	{
		super();
	}
	
/*	@BeforeClass
	public void userPageSetup()
	{
		initialization();
		loginPage = new LoginPage();
	    loginPage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	    addUserPage = new AddUserPage();
		userpage = new UserPage();		
	}*/
	
	@Test(priority=1)
	public void verifyUserLink()
	{
		userpage =userpage.clickOnUserLink();		
	}
	
	@Test(priority=2, description="Validate User Page Title", groups="Regression")
	public void verifyUserPageTitle()
	{
		String actualTitle = userpage.userPageTitleTest();
		Assert.assertEquals(actualTitle, "AdminLTE 2 | User");
	}
	
	@Test(priority=3, description="Validate User Page Label", groups="Regression")
	public void verifyUserPageLabel() 
	{
		String actualLabel = userpage.userPageLabelTest();
		Assert.assertEquals(actualLabel, "Users");
	}
	
	@Test(priority=4, description="Validate Add User Page Button", groups="Regression")
	public void verifyLoginPageBtn()
	{
		boolean addUserBtn = userpage.addUserBtnTest();
		Assert.assertTrue(addUserBtn);
		
		}
	
	@Test(priority=5)
    public void verifyadduser() {
		addUserPage=userpage.clickOnAddUser();
	}
    
    
	
	
}
