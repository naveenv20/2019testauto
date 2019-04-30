package com.qtpselenium.hybrid.examplecode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Dragging {

	public static void main(String[] args) {
		
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");

	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://jqueryui.com/draggable/");
	int s = driver.findElements(By.tagName("iframe")).size();
	System.out.println("Total frames "+ s);
	driver.switchTo().frame(0);
	WebElement e = driver.findElement(By.id("draggable"));
	Actions act = new Actions(driver);
	act.dragAndDropBy(e, 100, 100).build().perform();
	driver.switchTo().defaultContent();// come out of frame
	

	}

}
