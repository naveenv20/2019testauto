package com.qtpselenium.hybrid.examplecode.uploading;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class FaceBook {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
//		  FirefoxOptions options = new FirefoxOptions();
//		  ProfilesIni profile = new ProfilesIni();
//		  FirefoxProfile myprofile = profile.getProfile("Test_Prof");
//		  myprofile.setPreference("dom.webnotifications.enabled", false);
//	      options.setProfile(myprofile);

	     
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("its.thakur@gmail.com");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("8968585110");
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//div[text()='Ashish Thakur']")).click();
		///WebElement profileSelector = driver.findElement(By.xpath("//div[@id='fbProfilePicSelector']"));
		WebElement profilePic = driver.findElement(By.xpath("//img[@class='profilePic img']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		
		driver.findElement(By.xpath("//a[@rel='dialog']/i")).click();
	    Thread.sleep(5000);

	    driver.findElement(By.xpath("//span[text()='Upload Photo']")).click();
	    Thread.sleep(5000);
	     new ProcessBuilder("D:\\fb2.exe").start();
		
		
	}
}
