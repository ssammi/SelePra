package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sam.common.*;

public class HomePageFactory {
	private WebDriver driver;
	public CommonMethods CM;
	
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/div/div[1]/a[1]/u")
	private WebElement LOGYOURSELFLINK;
	
	@FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[2]/u")
	private WebElement CREATEACCOUNT;
	
	@FindBy(how = How.XPATH, using ="//img[@alt='Samsung Galaxy Tab']")
	private WebElement CLICKIMG;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']/span")
	private WebElement LOGOFF;
	
	public HomePageFactory(WebDriver driver){
		this.driver = driver;
		CM = new CommonMethods(driver);
		PageFactory.initElements(this.driver, this);
		String ExpectedText = "Welcome to iBusiness";
		String ActualText = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
	    Assert.assertEquals(ExpectedText,ActualText);
	    
	    //set ExpectedText and get actual text then compare
	}
	
	public void clickLogyourselfLink(){
		//LOGYOURSELFLINK.click();
		CM.click(LOGYOURSELFLINK);
		//System.out.println("click link");
	}
	
	public void clickcreateaccount(){
		CM.click(CREATEACCOUNT);
	}
	
	public void clickimg(){
		//CLICKIMG.click();
		CM.click(CLICKIMG);
		//System.out.println("click image");
	}
	
	public void clickLogOff(){
		//driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		//LOGOFF.click();
		CM.click(LOGOFF);
		//System.out.println("click the log off ");
	}

}
