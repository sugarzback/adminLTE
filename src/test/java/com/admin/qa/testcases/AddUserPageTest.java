package com.admin.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.AddUserPage;
import com.admin.qa.pages.Dashboard;
import com.admin.qa.pages.LoginPage;
import com.admin.qa.pages.UserPage;
import com.admin.qa.util.TestDataProvider;

public class AddUserPageTest extends TestBase {

	LoginPage loginPage;
	Dashboard dashboard;
	UserPage userPage;
	AddUserPage addUserPage = new AddUserPage();
	
	public AddUserPageTest() 
	{
		super();
	}
	
	/*@BeforeMethod
	public void addUserPageSetup() 
	{
		initialization();
		loginPage = new LoginPage();
		dashboard = loginPage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.clickOnUserLink();
		userPage = new UserPage();
		addUserPage= userPage.clickOnAddUser();		
	}*/
	
	@Test(priority=1, description="Validate Add User Page Title", groups="Regression")
	public void verifyAddUserPageTitle()
	{
		String actualTitle = addUserPage.addUserPageTitleTest();
		Assert.assertEquals(actualTitle, "AdminLTE 2 | Add User");
	}
	
	@Test(priority=2, description="Validate Add User Page Label", groups="Regression")
	public void verifyAddUserPageLabel()
	{
		String actualLabel = addUserPage.addUserPageLabelTest();
		Assert.assertEquals(actualLabel, "Add Userv");
	}
	
	@Test(priority=3, description="Validate Add User Form Labels", groups="Regression")
	public void verifyAddUserPageFormLables()
	{
		List<String> actuaFormLabels = addUserPage.addUserPageFormLabelsTest();
		List<String> expectedFormLabels = new ArrayList<String>();
		
		expectedFormLabels.add("Username");
		expectedFormLabels.add("Mobile");
		expectedFormLabels.add("Email");
		expectedFormLabels.add("Gender");
		expectedFormLabels.add("State");
		expectedFormLabels.add("Password");
		
		Assert.assertEquals(actuaFormLabels, expectedFormLabels);
	}
	
	@Test(priority=4, dataProvider="userData", dataProviderClass=TestDataProvider.class, description="Validate Add User Form", groups="Regression")
	public void verifyAddUserForm(String username, String mobile, String email, String gender, String state, String password)
	{
		String actualAlertText = addUserPage.addNewUserTest(username,mobile,email,gender,state,password);
		Assert.assertEquals(actualAlertText,"User Added Successfully. You can not see added user.","Add User Failed");     		
	}
	
}
