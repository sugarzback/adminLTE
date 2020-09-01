package com.admin.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.admin.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement pwd;
	
	@FindBy(xpath="//*[@id=\"form\"]/div[3]/div/button")
	WebElement signbtn;
	
	@FindBy(xpath="/html/body/div/div[2]/p")
	WebElement logo;
	
	@FindBy(xpath="//a[@href='dashboard.html']")
	WebElement logo1;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifytitle() {
		String title= driver.getTitle();
		System.out.println(title);
		return title;
		
	}
	public String verifylogo() {
		String act=logo1.getText();
		Assert.assertEquals(act, "AdminLTE");
		System.out.println(act);
		return act;
	}
	
	
	public Dashboard verifylogin(String username,String password) {
		email.sendKeys(username);
		pwd.sendKeys(password);
		signbtn.click();
		return new Dashboard();
	}
	
}
