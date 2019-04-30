package com.qtpselenium.hybrid.examplecode;


import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Americangolf_mousemove {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://americangolf.co.uk");
		WebElement golfClubs = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
		Actions act = new Actions(driver);
		act.moveToElement(golfClubs).build().perform();
		WebDriverWait wait = new  WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span[1]"))));
		
		//driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span[1]")).click();
		
		WebElement box = driver.findElement(By.xpath("//*[@id='CLUBS_1']"));
		List<WebElement> links = box.findElements(By.tagName("a"));
		Random r = new Random();
		int n = r.nextInt(links.size());// 0 - (total-1)
		System.out.println("Total links "+ links.size());
		String text=links.get(n).getText();
		System.out.println(text);
		links.get(n).click();

	}

}
