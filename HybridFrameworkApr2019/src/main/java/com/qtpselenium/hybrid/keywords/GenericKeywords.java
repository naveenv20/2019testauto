package com.qtpselenium.hybrid.keywords;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.reports.ExtentManager;

public class GenericKeywords {
	
	public Properties envProp;
	public Properties prop;
	public String objectkey;
	public String datakey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	public ExtentTest test;
	public String proceedonFail;	
	public SoftAssert softAssert=new SoftAssert();
	

	/*******************Getter and setter***************************/

	public Properties getEnvProp() {
		return envProp;
	}

	public void setEnvProp(Properties envProp) {  
		this.envProp = envProp;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getObjectkey() {
		return objectkey;
	}

	public void setObjectkey(String objectkey) {
		this.objectkey = objectkey;
	}

	public String getDatakey() {
		return datakey;
	}

	public void setDatakey(String datakey) {
		this.datakey = datakey;
	}

	public Hashtable<String, String> getData() {
		return data;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void setTest(ExtentTest test) {
		this.test = test;
	}
	
	public void setProceedonFail(String proceedonFail) {
		this.proceedonFail=proceedonFail;
		
	}
	
	/*************************Operation Functions*********************/
	public void openBrowser() {
		String browser=data.get(datakey);
		//System.out.println("open browser"+ data.get(datakey));
		test.log(Status.INFO,"open browser "+ data.get(datakey));
		if(browser.equals("Mozilla")){
			//browser related log stopping them in console of eclipse --do this 
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			//invoke profile 
			System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browser.equals("Chrome")){
			ChromeOptions ops = new ChromeOptions();	
			
			 ops.addArguments("--disable-notifications");
	         ops.addArguments("disable-infobars");
	         ops.addArguments("--start-maximized");
	         //ops.addArguments("--proxy-server=http://83.209.94.87:8123");
	         //ops.addArguments("user-data-dir=C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\");// Dont give default folder
	         
	        // ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
	        // ops.setBinary("PATH TO EXE");

			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "D://chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			
			
			System.setProperty("webdriver.chrome.driver", "C:\\Seli\\browsers\\chromedriver.exe");
			driver=new ChromeDriver(ops);
		}
		
		//maximise the browser
		driver.manage().window().maximize();
		//set the implicit wait
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
	}
	
	public void click() {
		//System.out.println("click"+ prop.getProperty(objectkey));
		test.log(Status.INFO,"click "+ prop.getProperty(objectkey));
		getelement(objectkey).click();
		//test.log(Status.INFO,"after click ");
	}
	
	
	public void type() {
		//System.out.println("type on object: "+ prop.getProperty(objectkey)+"   and value is"+data.get(datakey));
		test.log(Status.INFO,"type on object: "+ prop.getProperty(objectkey)+"   and value is"+data.get(datakey));
		getelement(objectkey).clear();
		getelement(objectkey).sendKeys(data.get(datakey));
	}	
	
	public void navigate() {
		//System.out.println("navigate"+ envProp.getProperty(objectkey));
		test.log(Status.INFO,"navigate "+ envProp.getProperty(objectkey));
		driver.get(envProp.getProperty(objectkey));
	}
	
	public void quit(){
		test.log(Status.INFO,"quitting browser");
	if(driver!=null)
		driver.quit();
	}
	
	public void select(){
		test.log(Status.INFO, "selecting a value from dropdown");
		//Select element= new Select(getelement(objectkey));
		String new_xpath=prop.getProperty("ms_select_value1_xpath")+data.get(datakey)+prop.getProperty("ms_select_value2_xpath");
		getelement(objectkey).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "selecting xpath value is : "+new_xpath);
		getelementbyxpath(new_xpath).click();
	}
	
	//centralised function to extract the web element
	
	public WebElement getelement(String objectkey) {
		WebElement e=null;
		try {
			
			if(objectkey.endsWith("_xpath"))
			e=driver.findElement(By.xpath(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_id"))
				e=driver.findElement(By.id(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_css"))
				e=driver.findElement(By.cssSelector(prop.getProperty(objectkey)));	
			else if(objectkey.endsWith("_name"))
				e=driver.findElement(By.name(prop.getProperty(objectkey)));	
			//visibility object 
		WebDriverWait wait = new WebDriverWait(driver, 20);		
		wait.until(ExpectedConditions.visibilityOf(e));
		//state of object 
		wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		catch (Exception exe) {
			exe.printStackTrace();
			//failure
			reportFailure("Object Not found : "+ objectkey);
		}
				return e;
	}
	
	
	public WebElement getelementbyxpath(String xpath){
		WebElement e=null;
		try {
			e=driver.findElement(By.xpath(xpath));
			
		}catch (Exception exe) {
			//failure
			reportFailure("Object Not found from xpath function: "+ objectkey);
		}
		return e;
	}
	
	public boolean isElementPresent(String objectkey ){
		List<WebElement> abc=null;
		if(objectkey.endsWith("_xpath"))
			abc=driver.findElements(By.xpath(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_id"))
				abc=driver.findElements(By.id(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_css"))
				abc=driver.findElements(By.cssSelector(prop.getProperty(objectkey)));	
			else if(objectkey.endsWith("_name"))
				abc=driver.findElements(By.name(prop.getProperty(objectkey)));
		if(abc.size()>0){
			return true;
		}
		else
			return false;
	}
	
	public void validateTitle(){
		test.log(Status.INFO,"Inside the validate title function");	
	}
	
	public void dynamicwaitgap(){
		test.log(Status.INFO,"inside dyanmicwait function");	
	
		WebDriverWait w2=new WebDriverWait(driver, 30);
		w2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((prop.getProperty("hourglass_icon_xpath")))));
		WebElement f=driver.findElement(By.xpath(prop.getProperty("hourglass_icon_xpath")));
		if(!isElementPresent("hourglass_icon_xpath")){
			reportFailure("Object Not found :::"+ "hourglass_icon_xpath");
		}
		else{
			test.log(Status.INFO,"object found "+ "hourglass_icon_xpath");	
		}
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(prop.getProperty("hourglass_icon_xpath")))));

	}
	public String gettext() {
		String actualval=getelement(objectkey).getText();
		return actualval;
		
	}
	
	/************reporting function *****************/
	public void reportFailure(String failuremessage){
		//fail the test case
		test.log(Status.FAIL,failuremessage);
		//take screenshot and embed it in the reports
		//fail in testng
		takeScreenshoot();
		if(proceedonFail.equalsIgnoreCase("Y")){// use softassertion
			test.log(Status.INFO,"inside report failure if case");
		softAssert.fail(failuremessage);
		}
		else{
			test.log(Status.INFO,"inside report failure else case");
			softAssert.fail(failuremessage);
			softAssert.assertAll();
		}
			
	}
	
	public void takeScreenshoot(){
	//screenshot file name and path 
		// fileName of the screenshot
				Date d=new Date();
				String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				// take screenshot
				File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					// get the dynamic folder name
					FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
					//put screenshot file in reports
					test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void assertall(){
		softAssert.assertAll();
	}
}
