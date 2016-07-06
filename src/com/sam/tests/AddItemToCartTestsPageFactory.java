package com.sam.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.sam.common.*;
import com.sam.pageproject.*;

public class AddItemToCartTestsPageFactory {
	private WebDriver driver;
	public String getURL="http://107.170.213.234/catalog/index.php";
	//define url
	public LoginPageFactory LoginPage;
	public HomePageFactory HomePage;
	public ProductInfoPageFactory ProductInfoPage;
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
	public void checkoutWithoutLogin(){
		System.out.println("Begin testing checkout without login");
		HomePage = new HomePageFactory(driver);
			//pass driver to home page
		HomePage.clickimg();
		ProductInfoPage = new ProductInfoPageFactory(driver);
			//pass driver to productInfoPage
		ProductInfoPage.clickAddtoCartWithoutLogin();
			//click add items to cart
		ProductInfoPage.clickcheckoutwithoutlogin();
			//click check out link
		CM.verifyText("Welcome, Please Sign In");
		
	}
	
	@Test
	public void checkoutWithLogin(){
		System.out.println("Begin testing checkout with login");
		HomePage = new HomePageFactory(driver);
			//pass driver to home page
		HomePage.clickLogyourselfLink();
		LoginPage = new LoginPageFactory(driver);
			//pass driver to login page
		LoginPage.Login("ecalix@test.com", "test123");
			//pass username and pwd to login
		CM.verifyText("Welcome to iBusiness");
			//pass text to common to verify
		HomePage.clickimg();
		ProductInfoPage = new ProductInfoPageFactory(driver);
			//pass driver to productInfoPage
		ProductInfoPage.clickAddtoCartWithLogin();
			//click add items to cart
		ProductInfoPage.clickcheckoutwithlogin();
			//click check out link
		CM.verifyText("Delivery Information");
	}
}
