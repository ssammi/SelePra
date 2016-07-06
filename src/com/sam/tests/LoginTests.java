package com.sam.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.sam.common.*;
import com.sam.pageproject.*;

public class LoginTests {
	private WebDriver driver;
	public String getURL="http://107.170.213.234/catalog/index.php";
	//define url
	public LoginPage LoginPage;
	public HomePage HomePage;
	public CommonMethods CM;
	
	@BeforeMethod
	public void setUp(){
		CM = new CommonMethods(driver);
		//passing the driver to commonMethods
		driver = CM.openBrowser("Chrome");
		//passing the browser type 
		CM.goToURL(getURL);
		//passing the URL to common
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(){
		CM.closeBrowser();
		//close the browser
	}
	
	@Test
	public void testLogin(){
		HomePage = new HomePage(driver);
		//pass driver to home page
		HomePage.clickLogyourselfLink();
		LoginPage = new LoginPage(driver);
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
		HomePage = new HomePage(driver);
		//pass driver to home page
		HomePage.clickLogyourselfLink();
		LoginPage = new LoginPage(driver);
		//pass driver to login page
		LoginPage.clickSignIn();
		String ExpectedText="Error: No match for E-Mail Address and/or Password.";
		CM.verifyText(ExpectedText);
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
