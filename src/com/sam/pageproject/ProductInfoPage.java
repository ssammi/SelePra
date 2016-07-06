package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductInfoPage {
	private WebDriver driver;
	
	public ProductInfoPage(WebDriver driver){
		this.driver = driver;
//		String ExpectedText = "Welcome to iBusiness";
//		String ActualText = driver.findElement(By.cssSelector("h1")).getText();
//		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
//	    Assert.assertEquals(ExpectedText,ActualText);
	    
	    //set ExpectedText and get actual text then compare
	}
	
	public void clickAddtoCartWithLogin(){
		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
		System.out.println("click Add to cart");
	}
	
	public void clickAddtoCartWithoutLogin(){
		driver.findElement(By.xpath("//*[@id='tdb4']")).click();
		System.out.println("click Add to cart");
	}
	
	public void clickcheckoutwithlogin(){
		driver.findElement(By.xpath("//*[@id='tdb6']")).click();
		System.out.println("click Check out with user logged in");
	}
	
	public void clickcheckoutwithoutlogin(){
		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
		System.out.println("click Check out without logged in");
	}
	
	
	

}
