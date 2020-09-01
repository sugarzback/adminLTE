package com.admin.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.admin.qa.base.TestBase;

public class AddUserPage extends TestBase {

	@FindBy(xpath="//h1[contains(text(),'Add User')]")
	WebElement addUserPageLabel;
	
	@FindBy(xpath="//label[text()='Username']")
	WebElement usernameLabel;
	
	@FindBy(xpath="//label[text()='Mobile']")
	WebElement mobileLabel;
	
	@FindBy(xpath="//label[text()='Email']")
	WebElement emailLabel;
	
	@FindBy(xpath="//label[text()='Gender']")
	WebElement genderLabel;
	
	@FindBy(xpath="//label[text()='State']")
	WebElement stateLabel;
	
	@FindBy(xpath="//label[text()='Password']")
	WebElement  passwordLabel;
	
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="mobile")
	WebElement mobile;
	
	@FindBy(id="email")
	WebElement email;

	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="Male")
	WebElement male;

	@FindBy(id="Female")
	WebElement female;
		
	@FindBy(xpath="/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[5]/div/select")
	WebElement state;
	
	@FindBy(id="sumbit")
	WebElement submitbtn;

	@FindBy(xpath="/html/body/div/div[1]/section[2]/div/div/div/form/div[2]/a/span")
	WebElement cancelbtn;
	

	public AddUserPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String addUserPageTitleTest()
	{
		return driver.getTitle();		
	}
	
	public String addUserPageLabelTest()
	{
		return addUserPageLabel.getText();
	}
	
	public List<String>	addUserPageFormLabelsTest()
	{
		//List<String> formLabels = new ArrayList<String>();
		List<String> formLabels = new ArrayList<String>();
		
		formLabels.add(usernameLabel.getText());
		formLabels.add(mobileLabel.getText());
		formLabels.add(emailLabel.getText());
		formLabels.add(genderLabel.getText());
		formLabels.add(stateLabel.getText());
		formLabels.add(passwordLabel.getText());
		
		return formLabels;
	}
	
	public String addNewUserTest(String u_name, String u_mobile, String u_email, String u_gender, String u_state, String u_pass)
	{
		username.sendKeys(u_name);
		mobile.sendKeys(u_mobile);
		email.sendKeys(u_email);
		
		if (u_gender.equalsIgnoreCase("Male"))
		{
			male.click();			
		}
		else if (u_gender.equalsIgnoreCase("Female"))
		{
			female.click();			
		}
		
		Select select = new Select(state);
		select.selectByVisibleText(u_state);
		password.sendKeys(u_pass);
		submitbtn.click();
		
		return driver.switchTo().alert().getText();
	}

}
