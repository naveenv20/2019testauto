package com.qtpselenium.hybrid.examplecode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Js_Executor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//object casting 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location='https://mail.rediff.com/cgi-bin/login.cgi'");
		String state = (String)js.executeScript("return document.readyState");
		System.out.println(state);
		Thread.sleep(5000);
		js.executeScript("document.getElementById('login1').value='hello';");
		js.executeScript("window.scrollTo(0,200)");
		//https://www.w3schools.com/jsref/met_document_getelementbyid.asp
		

	}

}
