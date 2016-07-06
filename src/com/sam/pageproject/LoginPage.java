package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sam.common.*;
import com.sam.pageproject.*;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		Assert.assertEquals("Welcome, Please Sign In", driver.findElement(By.cssSelector("h1")).getText());
		//check if the right page loaded
	}
	
	public void clickSignIn(){
		driver.findElement(By.xpath("//*[@id='tdb5']/span[2]")).click();
		System.out.println("click the sign in ");
	}

	public void enterEmailID(String stext){
		driver.findElement(By.name("email_address")).sendKeys(stext);
		System.out.println("Entering the username");
	}
	
	public void enterPWD(String stext){
		driver.findElement(By.name("password")).sendKeys(stext);
		System.out.println("Entering the password");
	}
	
	public HomePage Login(String Username, String PWD){
		enterEmailID(Username);
		enterPWD(PWD);
		clickSignIn();
		return new HomePage(driver);
	}
	
	public void LoginWithValidUserName(){
		enterEmailID("ecalix@test.com");
	    enterPWD("test123");
	    clickSignIn();
		
	}
	
}
