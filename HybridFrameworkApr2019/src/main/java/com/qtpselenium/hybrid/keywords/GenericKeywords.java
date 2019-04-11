package com.qtpselenium.hybrid.keywords;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

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
			driver=new FirefoxDriver();
		}
		else if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Seli\\browsers\\chromedriver.exe");
			driver=new ChromeDriver();
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
	
	//centralised function to extract the web element
	
	public WebElement getelement(String objectkey) {
		WebElement e=null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			if(objectkey.endsWith("_xpath"))
			e=driver.findElement(By.xpath(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_id"))
				e=driver.findElement(By.id(prop.getProperty(objectkey)));
			else if(objectkey.endsWith("_css"))
				e=driver.findElement(By.cssSelector(prop.getProperty(objectkey)));	
			else if(objectkey.endsWith("_name"))
				e=driver.findElement(By.name(prop.getProperty(objectkey)));	
			//visibility object 
				
		wait.until(ExpectedConditions.visibilityOf(e));
		//state of object 
		wait.until(ExpectedConditions.elementToBeClickable(e));
		}
		catch (Exception exe) {
			//failure
			reportFailure("Object Not found : "+ objectkey);
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
	
	/************reporting function *****************/
	public void reportFailure(String failuremessage){
		//fail the test case
		test.log(Status.FAIL,failuremessage);
		//take screenshot and embed it in the reports
		//fail in testng
		if(proceedonFail.equalsIgnoreCase("Y")){// use softassertion
		softAssert.fail(failuremessage);
		}
		else{
			softAssert.fail(failuremessage);
			softAssert.assertAll();
		}
			
	}
	
	public void assertall(){
		softAssert.assertAll();
	}
}
