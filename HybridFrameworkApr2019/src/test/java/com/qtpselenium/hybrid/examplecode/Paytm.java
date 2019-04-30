package com.qtpselenium.hybrid.examplecode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Paytm {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
	
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://paytm.com");
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();
		int total = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total frames - "+ total);
		
		//driver.switchTo().frame(0);// switch to first frame
		//driver.findElement(By.id("input_0")).sendKeys("918982");
		//driver.switchTo().defaultContent();
		
		for(int i=0;i<total;i++){
			driver.switchTo().frame(i);
			int s = driver.findElements(By.id("input_0")).size();
			System.out.println("Size - "+s);
			
			if(s==0)
				driver.switchTo().defaultContent();
			else // found the frame
				break;
				
		}
		// interact
		driver.findElement(By.id("input_0")).sendKeys("918982");
		driver.switchTo().defaultContent();

	}

}
