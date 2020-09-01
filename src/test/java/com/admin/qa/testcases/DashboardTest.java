package com.admin.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.Dashboard;
import com.admin.qa.pages.LoginPage;
import com.admin.qa.pages.LogoutPage;
import com.admin.qa.pages.UserPage;

public class DashboardTest extends TestBase{

	LoginPage loginpage;
	Dashboard dashboard;
	UserPage userpage;
	LogoutPage logoutPage = new LogoutPage();
	
	public DashboardTest() {
		super();
	}
	
	/*@BeforeClass
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		dashboard=new Dashboard();
		userpage=new UserPage();
		loginpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}*/
	@Test(priority=1, description="Validate Dashboard Page Title", groups="Regression")
	public void checktitle() {
		String actualTitle=dashboard.verifytitle();
		Assert.assertEquals(actualTitle, "AdminLTE 2 | Dashboard");
     
	}
	
	@Test(priority=2, description="Validate Dashboard Page Label", groups="Regression")
	public void verifyDashboardPageLabel()
	{
		String actualLabel = dashboard.dashboardPageLabelTest();
		Assert.assertEquals(actualLabel, "Dashboard Control panel");
	}
	
	@Test(priority=3, description="Validate Logged User", groups="Regression")
	public void verifyLoggedUser() 
	{
		boolean loggedUser = dashboard.loggedUserTest();
		Assert.assertTrue(loggedUser);		
	}
	
	@Test(priority=4, description="Validate user link", groups="Regression")
	public void verifyUserLink()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userpage =dashboard.clickOnUserLink();		
	}
	
	@Test(priority=5, description="Validate operator link", groups="Regression")
	public void checklogo()  {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logoutPage=dashboard.verifylogout();
     }
	
	
	
}
