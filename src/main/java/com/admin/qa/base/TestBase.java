package com.admin.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.admin.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Actions action;
	public static WebDriverWait wait;
	
	
	
	public TestBase(){
		prop=new Properties();
		try {
			//FileInputStream fis=new FileInputStream("D:\\Demo Project\\ShopCart\\src\\main\\java\\com\\shopcart\\qa\\config\\Config.properties");
			FileInputStream fis=new FileInputStream("C:\\Demo Project\\Aug2020\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
	
	public static void initialization() {
		String browser=prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\firefoxdriver.exe");
			driver=new FirefoxDriver();
	}
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
}
}
