package com.qtpselenium.hybrid.keywords;

import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeywords {
	
	public Properties envProp;
	public Properties prop;
	public String objectkey;
	public String datakey;
	public Hashtable<String, String> data;
	public WebDriver driver;
		
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

	
	/*************************Operation Functions*********************/
	public void openBrowser() {
		String browser=data.get(datakey);
		System.out.println("open browser"+ data.get(datakey));
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
		System.out.println("click"+ prop.getProperty(objectkey));
		driver.findElement(By.xpath(prop.getProperty(objectkey))).click();
		
	}
	
	
	public void type() {
		System.out.println("type on object: "+ prop.getProperty(objectkey)+"   and value is"+data.get(datakey));
		driver.findElement(By.xpath(prop.getProperty(objectkey))).clear();
		driver.findElement(By.xpath(prop.getProperty(objectkey))).sendKeys(data.get(datakey));
	}
	
	public void navigate() {
		System.out.println("navigate"+ envProp.getProperty(objectkey));
		driver.get(envProp.getProperty(objectkey));
	}
}
