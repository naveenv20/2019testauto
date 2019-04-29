package com.qtpselenium.hybrid.examplecode;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Naukri_multiwindow {

	public static void main(String[] args) {
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		//System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Seli\\browsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// 1 window
		Set<String> winIds = driver.getWindowHandles();
		System.out.println("Total windows - "+ winIds.size());
		
		if(winIds.size()>1){
			// pop is present - detect popups
		}
		Iterator<String> it = winIds.iterator();
		System.out.println(it.next());
		driver.get("http://naukri.com");
		System.out.println("------------------------");
		winIds = driver.getWindowHandles();
		System.out.println("Total windows - "+ winIds.size());
		it = winIds.iterator();
		String mainWindowID = it.next();
		String firstPopup = it.next();
		String secondPopup = it.next();
		String thirdPopup = it.next();
		System.out.println(mainWindowID);
		System.out.println(firstPopup);
		System.out.println(secondPopup);
		System.out.println(thirdPopup);
		
		driver.switchTo().window(firstPopup);
		// - fired on 1st pop
		driver.close();// closes window under focus
		driver.switchTo().window(secondPopup);
		driver.close();
		driver.switchTo().window(thirdPopup);
		driver.close();
		
		driver.switchTo().window(mainWindowID);
		//driver.switchTo().defaultContent();

		driver.quit(); // close all windows and end selenium session
	}

}
