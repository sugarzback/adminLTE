package com.admin.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.admin.qa.base.TestBase;
import com.admin.qa.pages.Dashboard;
import com.admin.qa.pages.LoginPage;

public class LoginTest extends TestBase{
 
	LoginPage loginpage;
	Dashboard dashboard;
	
	
	public LoginTest() {
		super();
	}
	
	@BeforeClass
	public void setup() {
		initialization();
		loginpage=new LoginPage();
		dashboard=new Dashboard();
		
	}
	@Test
	public void checktitle() {
		loginpage.verifytitle();
		
     }
		
	@Test
	public void checklogo() {
		loginpage.verifylogo();
     }
	
	@Test
	public void checklogin() {
		loginpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
     }
	
}
