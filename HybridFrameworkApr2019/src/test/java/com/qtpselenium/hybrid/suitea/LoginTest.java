package com.qtpselenium.hybrid.suitea;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.driver.DriverScript;
import com.qtpselenium.hybrid.util.Constants;
import com.qtpselenium.hybrid.util.DataUtil;


//name of the java file should be same as the name in xls file
public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String, String> data ) throws Exception {
		test.log(Status.INFO, "starting");
		
		if(DataUtil.isSkip(testName, xls)||data.get(Constants.RUNMODE_COL).equals(Constants.RUNMODE_NO)){
			test.log(Status.SKIP, "Test Case configured as No: "+ testName);
			throw new SkipException("Run mode is No");
		}
	//make sure that u have my prop and xls file objects
		//before test starts
		
	System.out.println("Running Login test");	
	
	ds.executeKeywords(testName, xls, data);
		
		
	}
	
	
	

}
