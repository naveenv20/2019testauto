package com.qtpselenium.hybrid.examplecode;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RediffAlert {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new ChromeDriver();// 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("someuser");
		driver.findElement(By.name("proceed")).click();
		// while for alert to come
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al = driver.switchTo().alert();// switch control to alert
		System.out.println(al.getText());
		al.accept();//ok
		//al.dismiss();
		driver.switchTo().defaultContent();// back to main page
		
		
		
		
		
		

	}

}
