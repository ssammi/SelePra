package com.sam.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.sam.common.*;
import com.sam.pageproject.*;

public class LoginTestsPageFactory {
	private WebDriver driver;
	public String getURL="http://107.170.213.234/catalog/index.php";
	//define url
	public LoginPageFactory LoginPage;
	public HomePageFactory HomePage;
	public CommonMethods CM;
	
	@BeforeMethod
	public void setUp(){
		Properties prop = new Properties();
		InputStream input = null;
		
		try{
			input = new FileInputStream("config.properties");
			prop.load(input);
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		CM = new CommonMethods(driver);
		//passing the driver to commonMethods
		String gBrowser = prop.getProperty("BrowserType");
		String gUrl = prop.getProperty("URL");
		driver = CM.openBrowser(gBrowser);
		//passing the browser type 
		CM.goToURL(gUrl);
		//passing the URL to common
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		CM.closeBrowser();
		//close the browser
	}
	
	@Test
	public void testLogin(){
		System.out.println("Test log in with correct name and password");
		HomePage = new HomePageFactory(driver);
		//pass driver to home page
		HomePage.clickLogyourselfLink();
		LoginPage = new LoginPageFactory(driver);
		//pass driver to login page
		LoginPage.Login("ecalix@test.com", "test123");
		//pass username and pwd to login
		CM.verifyText("Welcome to iBusiness");
		//pass text to common to verify
		HomePage.clickLogOff();
		//logoff
		
	}
	
	@Test
	public void testLoginError(){
		System.out.println("Test log in with nothing");
		HomePage = new HomePageFactory(driver);
		//pass driver to home page
		HomePage.clickLogyourselfLink();
		LoginPage = new LoginPageFactory(driver);
		//pass driver to login page
		LoginPage.clickSignIn();
		String ExpectedText="Error: No match for E-Mail Address and/or Password.";
		CM.verifyText(ExpectedText);
		
		
	}

}
