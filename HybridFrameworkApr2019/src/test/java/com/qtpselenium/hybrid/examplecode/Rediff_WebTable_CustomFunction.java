package com.qtpselenium.hybrid.examplecode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Rediff_WebTable_CustomFunction {
	static WebDriver driver;
	
	public static void main(String[] args) {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		System.setProperty("webdriver.gecko.driver", "C:\\Seli\\browsers\\geckodriver.exe");
	    driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		int rNum = getRowNumWithCellData("IDFC L");
		System.out.println(rNum);
		String price = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+rNum+"]/td[4]")).getText();
		System.out.println(price);

	}
	
	
	public static int getRowNumWithCellData(String data){
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		
		for(int rNum=0;rNum<rows.size();rNum++){
			WebElement row = rows.get(rNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cNum=0;cNum<cells.size();cNum++){
				String cellData = cells.get(cNum).getText();
				if(cellData.equals(data))
					return ++rNum;
			}
		}
		
		return -1;
	}

}
