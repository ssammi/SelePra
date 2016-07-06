package com.sam.pageproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
	private WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		String ExpectedText = "Welcome to iBusiness";
		String ActualText = driver.findElement(By.cssSelector("h1")).getText();
		System.out.println("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
	    Assert.assertEquals(ExpectedText,ActualText);
	    
	    //set ExpectedText and get actual text then compare
	}
	
	public void clickLogyourselfLink(){
		driver.findElement(By.xpath("//*[@id='bodyContent']/div/div[1]/a[1]/u")).click();
		System.out.println("click link");
	}
	
	public void clickimg(){
		driver.findElement(By.xpath("//img[@alt='Samsung Galaxy Tab']")).click();
		System.out.println("click image");
	}
	
	public void clickLogOff(){
		driver.findElement(By.xpath("//*[@id='tdb4']/span")).click();
		System.out.println("click the log off ");
	}

}
