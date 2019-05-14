package com.qtpselenium.hybrid.examplecode;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest_Module17 {

	WebDriver driver = null;

	@Test
	public void loginTest(){		
		String browser = "Mozilla";// xls, xml
		// script
		if(browser.equals("Mozilla")){
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			driver = new ChromeDriver();
		}else if(browser.equals("IE")){
			driver = new InternetExplorerDriver();
		}else if(browser.equals("Edge")){
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("http://in.rediff.com/");
		driver.findElement(By.xpath("//html/body/div[1]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/span[2]/a[1]")).click();
		driver.findElement(By.id("useremail")).sendKeys("nkuserone");
		driver.findElement(By.id("emailsubmit")).click();
		// wait 
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("userpass"))));
		driver.findElement(By.id("userpass")).sendKeys("King12345");
		driver.findElement(By.id("userpass")).sendKeys(Keys.ENTER);
		
		boolean result = isElementPresent("//*[@id='username']/a");
		Assert.assertTrue(result, "Not able to login");		
	}
	
	public boolean isElementPresent(String xpathExp){
		int s = driver.findElements(By.xpath(xpathExp)).size();
		if(s==0)
			return false;
		else
			return true;
	}
}
