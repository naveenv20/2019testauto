package com.qtpselenium.hybrid.examplecode;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AlertManagement {

	public static void main(String[] args) {
		
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
			
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("hello");
		driver.findElement(By.name("proceed")).click();
		
		// delay
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept();//ok
//		al.dismiss();// cancel
		
		driver.switchTo().defaultContent();
		

	}

}
