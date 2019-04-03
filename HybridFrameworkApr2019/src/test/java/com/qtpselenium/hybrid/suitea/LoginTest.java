package com.qtpselenium.hybrid.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.driver.DriverScript;
import com.qtpselenium.hybrid.util.DataUtil;


//name of the java file should be same as the name in xls file
public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String, String> data ) {
		
		
		if(data.get("Runmode").equals("N"))
			throw new SkipException("Run mode is No");
		
	//make sure that u have my prop and xls file objects
		//before test starts
	System.out.println("Running Login test");	
	ds=new DriverScript();
	ds.executeKeywords(testName, xls, data);
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		System.out.println("Inside data provider");
		return DataUtil.getTestData(testName, xls);
	}

}
