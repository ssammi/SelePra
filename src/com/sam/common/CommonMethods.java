package com.sam.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	private WebDriver driver;
	//why use private here
	//because each class will have its own driver 
	
	public CommonMethods(WebDriver driver){
		this.driver=driver;
		//how does this work 
		//this current driver = arg passed in driver
	}
	
	public void setdriver(WebDriver driver){
		this.driver=driver;
	}
	
	public WebDriver openBrowser(String browserType){
		//Receive browser type and open browser
		if (browserType.contentEquals("Firefox")){
			driver = new FirefoxDriver();
			System.out.println("Opening Firefox Browser");
		}else if (browserType.contentEquals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
			//what is these two line does
			DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			driver = new ChromeDriver(Capabilities);
			System.out.println("Opening Chrome Browser");
		}else{
			System.out.println("Please select a browser type");
			Assert.fail("Browser not selected");
		}
		driver.manage().window().maximize();
		System.out.println("Maximizing Window");
		driver.manage().deleteAllCookies();
		//should only detele current chrome page cookies
		System.out.println("Deleted all current page cookies");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//set timeout, if no responding in 30 second then timeout
		return driver;
	}
	
	public void goToURL(String sURL){
		//receive the URL
		driver.get(sURL);
		System.out.println("Opening url=" + sURL);
	}
	
	public void closeBrowser(){
		//quit web browser
		driver.quit();
		System.out.println("Browser closed");
	}
	
	public void verifyText(String expected){
		try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 System.out.println("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
	}
	
	public void clickByXpath(String stext){
		driver.findElement(By.xpath(stext)).click();
		System.out.println("Link is clicked");
	}
	
	public void setValue(WebElement slocator,String sValue){
		String Element=slocator.getText();
		try {	
			System.out.println(Element + "trying to set the value");
			slocator.clear();
			slocator.sendKeys(sValue);
			System.out.println(sValue + " entered");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(Element + "field not found");
		}
	}
	
	public void click(WebElement slocator){
		try {
			
			String Element=slocator.getText();
			if ((Element.isEmpty()) || (Element==null)){
				Element=slocator.getAttribute("value");
			}
			System.out.println(Element + " trying to click");

			slocator.click();
			System.out.println(Element + " clicked ");
			acceptPopup();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(slocator + " not clicked ");
		}
	}
	
	public void acceptPopup() {
		try {
			Alert alert = driver.switchTo().alert();
			//Thread.sleep(10000);
			alert.accept();
			driver.switchTo().defaultContent();
			System.out.println("Alert Accepted");
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			System.out.println("Alert not found");		
		}
	}
	
	public void dropdown(WebElement webelement, String selecttext){
//		Select gender = new Select(driver.findElement(By.xpath(webelement)));
		Select dropdown = new Select(webelement);
		dropdown.selectByVisibleText(selecttext);
		
		
	}
	
	public String readexcel(String filepath, int sheetnum, int rownum, int colnum)throws IOException{
		Object result;
		File file = new File(filepath);
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook workbook = new XSSFWorkbook(inputStream);
	    //Read sheet inside the workbook by its name
	    Sheet sh = workbook.getSheetAt(sheetnum);
	    Row row = sh.getRow(rownum);
	    Cell cell = row.getCell(colnum);
	    int type = cell.getCellType();
	    switch (type) {
		    case Cell.CELL_TYPE_NUMERIC:
		    	result = cell.getNumericCellValue();
		    break;
		    case Cell.CELL_TYPE_STRING: // String Value in Excel 
	            result = cell.getStringCellValue();
            break;
		    case Cell.CELL_TYPE_BLANK:
	            result = "";
	        break;
		    case Cell.CELL_TYPE_BOOLEAN: //boolean value 
	            result = cell.getBooleanCellValue();
            break;
	    
	    default:  
            throw new RuntimeException("There is no support for this type of cell"); 	
	    }
	    return result.toString();
	
	}
	
}
