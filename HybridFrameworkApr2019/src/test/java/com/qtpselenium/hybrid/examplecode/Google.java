package com.qtpselenium.hybrid.examplecode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Google {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://google.com");
		int x = driver.findElement(By.name("q")).getLocation().x;
		int y = driver.findElement(By.name("q")).getLocation().y;
		System.out.println(x+" -- "+y);
		driver.findElement(By.name("q")).sendKeys("hello");
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		System.out.println(options.size());
		

	}

}
