package com.qtpselenium.hybrid.examplecode;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class UnpredictablePopup {

	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
	
		WebDriver driver = new FirefoxDriver();
		driver.get("http://qtpselenium.com/test/unpredictable.php");
		Set<String> winIds = driver.getWindowHandles();
		//1 - main window
		//2 - main+popup
		System.out.println("Total windows "+winIds.size());
		if(winIds.size()==2){
			Iterator<String> it = winIds.iterator();
			String mainID = it.next();
			String popupID= it.next();
			driver.switchTo().window(popupID);
			driver.close(); 
			driver.switchTo().window(mainID);
		}
		

	}

}
