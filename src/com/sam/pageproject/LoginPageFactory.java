package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sam.common.*;
import com.sam.pageproject.*;

public class LoginPageFactory {
	private WebDriver driver;
	public CommonMethods CM;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb5']/span[2]")
	private WebElement CLICKSIGNIN;
	
	@FindBy(how = How.NAME, using ="email_address")
	private WebElement ENTEREMAILID;
	
	@FindBy(how = How.NAME, using ="password")
	private WebElement PWD;
	
	
	public LoginPageFactory(WebDriver driver){
		this.driver = driver;
		CM = new CommonMethods(driver);
		PageFactory.initElements(this.driver, this);
		Assert.assertEquals("Welcome, Please Sign In", driver.findElement(By.cssSelector("h1")).getText());
		//check if the right page loaded
	}
	
	public void clickSignIn(){
//		CLICKSIGNIN.click();
//		System.out.println("click the sign in ");
		CM.click(CLICKSIGNIN);
	}

	public void enterEmailID(String stext){
//		ENTEREMAILID.sendKeys(stext);
//		System.out.println("Entering the username");
		CM.setValue(ENTEREMAILID, stext);
	}
	
	public void enterPWD(String stext){
//		PWD.sendKeys(stext);
//		System.out.println("Entering the password");
		CM.setValue(PWD, stext);
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
