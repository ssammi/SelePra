package com.sam.pageproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sam.common.*;

public class CreateAccountPageFactory {
	private Logger logger= Logger.getLogger(CreateAccountPageFactory.class);
	private WebDriver driver;
	public CommonMethods CM;
//	Properties prop = new Properties();
//	InputStream input = null;
//
//	try{
//		input = new FileInputStream("config.properties");
//		prop.load(input);
//	}catch (IOException ex) {
//		ex.printStackTrace();
//	}finally {
//		if (input != null) {
//			try {
//				input.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	String path = prop.getProperty("path");
	
	
	@FindBy(how = How.XPATH, using ="//*[@id='tdb4']/span[2]")
	  private WebElement clickcontinue;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[2]/td[2]/input")
	  private WebElement firstname;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[3]/td[2]/input")
	  private WebElement lastname;
	@FindBy(how = How.XPATH, using ="//*[@id='dob']")
	  private WebElement birth;
	@FindBy(how = How.NAME, using ="email_address")
	  private WebElement email;
	@FindBy(how = How.NAME, using ="company")
	  private WebElement company;
	@FindBy(how = How.NAME, using ="street_address")
	  private WebElement street;
	@FindBy(how = How.NAME, using ="suburb")
	  private WebElement suburb;
	@FindBy(how = How.NAME, using ="postcode")
	  private WebElement post;
	@FindBy(how = How.NAME, using ="city")
	  private WebElement city;
	@FindBy(how = How.NAME, using ="state")
	  private WebElement state;
	@FindBy(how = How.NAME, using ="telephone")
	  private WebElement number;
	@FindBy(how = How.NAME, using ="fax")
	  private WebElement fax;
	@FindBy(how = How.NAME, using ="password")
	  private WebElement password;
	@FindBy(how = How.NAME, using ="confirmation")
	  private WebElement confirm;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")
	  private WebElement gendermale;
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[2]")
	  private WebElement genderfemale;
	@FindBy(how = How.NAME, using ="newsletter")
	  private WebElement news;
	@FindBy(how = How.NAME, using ="country")
	  private WebElement country;
	
	
	public CreateAccountPageFactory(WebDriver driver){
		this.driver = driver;
		CM = new CommonMethods(driver);
		PageFactory.initElements(this.driver, this);
//		String ExpectedText = "Welcome to iBusiness";
//		String ActualText = driver.findElement(By.cssSelector("h1")).getText();
//		logger.info("ExpectedText is="+ExpectedText+"\n"+"ActualText is="+ActualText);
//	    Assert.assertEquals(ExpectedText,ActualText);
	    
	    //set ExpectedText and get actual text then compare
	}
	
	public void firstname(String filepath, int sheetnum, int rownum, int colnum) throws IOException{
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		logger.info("click Add to cart");
		CM.setValue(firstname, CM.readexcel(filepath, sheetnum, rownum, colnum));
	}
//	
//	public void lastname(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb4']")).click();
////		logger.info("click Add to cart");
//		CM.setValue(lastname, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void dateofbirth(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb6']")).click();
////		logger.info("click Check out with user logged in");
//		CM.setValue(birth, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void company(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		logger.info("click Check out without logged in");
//		CM.setValue(company, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void address(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(street, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void suburb(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(suburb, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void postcode(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(post, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void city(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(city, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void country(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(country, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void number(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(number, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void fax(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(fax, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void password(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		CM.setValue(password, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
//	
//	public void confirm(String filepath, String sheetnum, int rownum, int colnum) throws IOException{
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		logger.info("click Check out without logged in");
//		CM.setValue(confirm, CM.readexcel(filepath, sheetnum, rownum, colnum));
//	}
	
	public void gender(){
//		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
//		logger.info("click Check out without logged in");
		
//		String gender = CM.readexcel(filepath, sheetnum, rownum, colnum);
//		if (gender.equals("Male")){
//			gendermale.click();
//		}else{
//			genderfemale.click();
//		}
		gendermale.click();
		logger.info("gender clicked");
	}
//	public void newsletter(String filepath, String sheetnum, int rownum, int colnum){
////		driver.findElement(By.xpath("//*[@id='tdb5']")).click();
////		logger.info("click Check out without logged in");
//		news.click();
//	}
	public void selectCountry(String selecttext){
		CM.dropdown(country, selecttext);
	}
	
	public void createaccount(String string1, String string2, String string3, String string4, String string5, String string6,
			                  String string7, String string8, String string9, String string10, String string11, String string12	){
		CM.setValue(firstname, string1);
		CM.setValue(lastname, string2);
		CM.setValue(birth, string3);
		CM.setValue(email, string4);
		CM.setValue(street, string5);
		CM.setValue(post, string6);
		CM.setValue(city, string7);
		//CM.setValue(country, string8);
		selectCountry(string8);
		CM.setValue(number, string9);
		CM.setValue(password, string10);
		CM.setValue(confirm, string11);
		CM.setValue(state, string12);
	}
	
	public void clickcontinue(){
		CM.click(clickcontinue);
	}
	
	
	
//	public void createaccount(int colnum) throws IOException{
//		filepath = "./Excel/CreateAccountTest.xlsx";
//		CM.setValue(firstname, CM.readexcel(filepath, 0, 1, colnum));
//		CM.setValue(lastname, CM.readexcel(filepath, 0, 2, colnum));
//		CM.setValue(birth, CM.readexcel(filepath, 0, 3, colnum));
//		CM.setValue(email, CM.readexcel(filepath, 0, 4, colnum));
//		CM.setValue(street, CM.readexcel(filepath, 0, 6, colnum));
//		CM.setValue(post, CM.readexcel(filepath, 0, 8, colnum));
//		CM.setValue(city, CM.readexcel(filepath, 0, 9, colnum));
//		CM.setValue(country, CM.readexcel(filepath, 0, 11, colnum));
//		CM.setValue(number, CM.readexcel(filepath, 0, 12, colnum));
//		CM.setValue(password, CM.readexcel(filepath, 0, 15, colnum));
//		CM.setValue(confirm, CM.readexcel(filepath, 0, 16, colnum));
//
//		}
	

}
