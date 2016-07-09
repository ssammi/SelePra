package com.sam.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.sam.common.*;
import com.sam.pageproject.*;

public class CreateAccountTest {
	private WebDriver driver;
	private Logger logger= Logger.getLogger(CreateAccountTest.class);
	public String getURL="http://107.170.213.234/catalog/index.php";
	//define url
	public LoginPageFactory LoginPage;
	public HomePageFactory HomePage;
	public CreateAccountPageFactory CreateAccountPage;
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
		String filepath = prop.getProperty("path");
		driver = CM.openBrowser(gBrowser);
		//passing the browser type 
		CM.goToURL(gUrl);
		//passing the URL to common
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown(ITestResult it) throws Exception{
		CM.postResults(it);
		driver.manage().deleteAllCookies();
		CM.closeBrowser();
		//close the browser
	}
	
	
	@Test
	public void clickcreateaccount() throws IOException{	
		logger.info("Click create account link");
		HomePage = new HomePageFactory(driver);
			//pass driver to home page
		HomePage.clickcreateaccount();	
		CreateAccountPage = new CreateAccountPageFactory(driver);
		CreateAccountPage.gender();
		String filepath = "./Excel/CreateAccountTest.xlsx";
		//CreateAccountPage.createaccount(1);
		CreateAccountPage.createaccount(CM.readexcel(filepath, 0, 1, 1).toString(), 
										CM.readexcel(filepath, 0, 2, 1).toString(), 
										CM.readexcel(filepath, 0, 3, 1).toString(), 
										CM.readexcel(filepath, 0, 4, 1).toString(), 
										CM.readexcel(filepath, 0, 6, 1).toString(), 
										CM.readexcel(filepath, 0, 8, 1).toString(), 
										CM.readexcel(filepath, 0, 9, 1).toString(), 
										CM.readexcel(filepath, 0, 11, 1).toString(), 
										CM.readexcel(filepath, 0, 12, 1).toString(), 
										CM.readexcel(filepath, 0, 15, 1).toString(), 
										CM.readexcel(filepath, 0, 16, 1).toString(),
										CM.readexcel(filepath, 0, 10, 1).toString());
		CreateAccountPage.clickcontinue();
		}
	
	@Test
	public void clickcreateaccount2() throws Exception{	
		logger.info("Click create account link");
		HomePage = new HomePageFactory(driver);
			//pass driver to home page
		HomePage.clickcreateaccount();	
		CreateAccountPage = new CreateAccountPageFactory(driver);
		CreateAccountPage.gender();
		String filepath = "./Excel/CreateAccountTest.xlsx";
		//CreateAccountPage.createaccount(1);
		CreateAccountPage.createaccount(CM.readexcel(filepath, 0, 1, 2).toString(), 
										CM.readexcel(filepath, 0, 2, 2).toString(), 
										CM.readexcel(filepath, 0, 3, 2).toString(), 
										CM.readexcel(filepath, 0, 4, 2).toString(), 
										CM.readexcel(filepath, 0, 6, 2).toString(), 
										CM.readexcel(filepath, 0, 8, 2).toString(), 
										CM.readexcel(filepath, 0, 9, 2).toString(), 
										CM.readexcel(filepath, 0, 11, 2).toString(), 
										CM.readexcel(filepath, 0, 12, 2).toString(), 
										CM.readexcel(filepath, 0, 15, 2).toString(), 
										CM.readexcel(filepath, 0, 16, 2).toString(),
										CM.readexcel(filepath, 0, 10, 2).toString());
//		getscreenshot();
		CreateAccountPage.clickcontinue();
		}
		
    public void getscreenshot() throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("./Excel/screenshot.png"));
    }

}
