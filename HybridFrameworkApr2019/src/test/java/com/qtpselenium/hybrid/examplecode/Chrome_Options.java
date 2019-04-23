package com.qtpselenium.hybrid.examplecode;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Chrome_Options {
	// pre requisites - careful with chrome version
	// logs
    // Notifications, info bars and maximized
	// page load strategy
	// binary
	// PROXY	
	// Profiling
	// certificate
	public static void main(String[] args) {
		 
		ChromeOptions ops = new ChromeOptions();	
		
		 ops.addArguments("--disable-notifications");
         ops.addArguments("disable-infobars");
         ops.addArguments("--start-maximized");
         //ops.addArguments("--proxy-server=http://83.209.94.87:8123");
         ops.addArguments("user-data-dir=C:\\Users\\lenovo\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1\\");// Dont give default folder
         
        // ops.setPageLoadStrategy(PageLoadStrategy.EAGER);
        // ops.setBinary("PATH TO EXE");

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "D://chrome.log");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	 
	    

		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://192.163.254.17");
	}

}
