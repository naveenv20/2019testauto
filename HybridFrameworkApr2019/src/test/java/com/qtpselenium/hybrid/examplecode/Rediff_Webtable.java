package com.qtpselenium.hybrid.examplecode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Rediff_Webtable {

	public static void main(String[] args) {
		String companyName="Biocon";
		
		// code
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		
		int cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
		int rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size();
		System.out.println("Rows - "+rows);
		System.out.println("Cols - "+cols);
		
		List<WebElement> names = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> currentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		System.out.println("Total names " +names.size());
		System.out.println("Total Prices "+currentPrices.size());
		
		for(int i=0;i<names.size();i++){
			if(companyName.equals(names.get(i).getText())){
				System.out.println(names.get(i).getText() +" --- "+ currentPrices.get(i).getText());
				break;
			}
		}



	}

}
