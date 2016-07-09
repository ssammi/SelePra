package com.sam.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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
import org.testng.ITestResult;

import com.sam.common.*;

public class CommonMethods {
	public  ReadPropertyFile ReadPropertyFile;
	private static int pass = 0;
	private static int fail = 0;
	private static String startTime;
	private static String endTime;
	private WebDriver driver;
	private Logger logger= Logger.getLogger(CommonMethods.class);
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
			logger.info("Opening Firefox Browser");
		}else if (browserType.contentEquals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
			//what is these two line does
			DesiredCapabilities Capabilities = DesiredCapabilities.chrome();
			Capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
			driver = new ChromeDriver(Capabilities);
			logger.info("Opening Chrome Browser");
		}else{
			logger.info("Please select a browser type");
			Assert.fail("Browser not selected");
		}
		driver.manage().window().maximize();
		logger.info("Maximizing Window");
		driver.manage().deleteAllCookies();
		//should only detele current chrome page cookies
		logger.info("Deleted all current page cookies");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//set timeout, if no responding in 30 second then timeout
		return driver;
	}
	
	public void goToURL(String sURL){
		//receive the URL
		driver.get(sURL);
		logger.info("Opening url=" + sURL);
	}
	
	public void closeBrowser(){
		//quit web browser
		driver.quit();
		logger.info("Browser closed");
	}
	@SuppressWarnings("static-access")
	 public void postResults( ITestResult it) throws SQLException{
			logger.info("Test description: " + it.getMethod().getDescription());
			logger.info("getMethod name:" +it.getMethod());
			logger.info("getName name:" +it.getName()); //tcID
			logger.info("getTestClass name:" +it.getTestClass()); //null
			logger.info("getThrow name:" +it.getThrowable());
			String TestCaseID = it.getName(); 
			String HostID=System.getenv().get("COMPUTERNAME");
			logger.info(HostID);
			ReadPropertyFile =new ReadPropertyFile();
			String className = it.getTestClass().toString().replace("[TestClass name=class", "");
			className = className.replace("]", "");
			
			if((pass+fail) == 0){
				SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				Date date = new Date();
				startTime = dateFormat.format(date);	
				logger.info("Start time: " + startTime);
			}
			
			if (it.isSuccess()){
				pass++;
				try {	
					logger.info("Pass");
					ScreenCapture screenCapture=new ScreenCapture(driver);
					String imgPath = screenCapture.takeScreenShoot(it.getMethod());
					}catch(Exception ex){
						logger.info(ex.getMessage());
					}
						
			}else{
				fail++;
				try
				{
					if(it.getStatus() == ITestResult.SKIP){
						logger.info("Skipped");
					
					}
					else{
						logger.info("Fail");
						ScreenCapture screenCapture=new ScreenCapture(driver);
						String imgPath = screenCapture.takeScreenShoot(it.getMethod());
					
										
						logger.info("screenshot captured for: " +it.getMethod()+ " Failed TestCase");
					}
								
					
					//closeBrowser();
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}


				
		}
	
	public void verifyText(String expected){
		try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		 }
	}
	
	public void clickByXpath(String stext){
		driver.findElement(By.xpath(stext)).click();
		logger.info("Link is clicked");
	}
	
	public void setValue(WebElement slocator,String sValue){
		String Element=slocator.getText();
		try {	
			logger.info(Element + "trying to set the value");
			slocator.clear();
			slocator.sendKeys(sValue);
			logger.info(sValue + " entered");
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(Element + "field not found");
		}
	}
	
	public void click(WebElement slocator){
		try {
			
			String Element=slocator.getText();
			if ((Element.isEmpty()) || (Element==null)){
				Element=slocator.getAttribute("value");
			}
			logger.info(Element + " trying to click");

			slocator.click();
			logger.info(Element + " clicked ");
			acceptPopup();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.info(slocator + " not clicked ");
		}
	}
	
	public void acceptPopup() {
		try {
			Alert alert = driver.switchTo().alert();
			//Thread.sleep(10000);
			alert.accept();
			driver.switchTo().defaultContent();
			logger.info("Alert Accepted");
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			logger.info("Alert not found");		
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
