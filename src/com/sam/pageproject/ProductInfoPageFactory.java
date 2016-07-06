package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sam.common.*;

public class ProductInfoPageFactory {
	private WebDriver driver;
	public CommonMethods CM;
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb5']")
	private WebElement ADDTOCARTWITHLOGIN;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']")
	private WebElement ADDTOCARTWITHOUTLOGIN;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb6']")
	private WebElement CHECKOUTWITHLOGIN;
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb5']")
	private WebElement CHECKOUTWITHOUTLOGIN;
	
	public ProductInfoPageFactory(WebDriver driver){
		this.driver = driver;
		CM = new CommonMethods(driver);
		PageFactory.initElements(this.driver, this);
//		String ExpectedText = "Welcome to iBusiness";
//		String ActualText = driver.findElement(By.cssSelector("h1")).getText();
//		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
//	    Assert.assertEquals(ExpectedText,ActualText);
	    
	    //set ExpectedText and get actual text then compare
	}
	
	public void clickAddtoCartWithLogin(){
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		System.out.println("click Add to cart");
		CM.click(ADDTOCARTWITHLOGIN);
	}
	
	public void clickAddtoCartWithoutLogin(){
//		driver.findElement(By.xpath("//*[@id='tdb4']")).click();
//		System.out.println("click Add to cart");
		CM.click(ADDTOCARTWITHOUTLOGIN);
	}
	
	public void clickcheckoutwithlogin(){
//		driver.findElement(By.xpath("//*[@id='tdb6']")).click();
//		System.out.println("click Check out with user logged in");
		CM.click(CHECKOUTWITHLOGIN);
	}
	
	public void clickcheckoutwithoutlogin(){
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		System.out.println("click Check out without logged in");
		CM.click(CHECKOUTWITHOUTLOGIN);
	}
	
	
	

}
