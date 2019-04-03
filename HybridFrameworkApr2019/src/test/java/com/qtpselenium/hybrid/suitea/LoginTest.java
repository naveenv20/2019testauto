package com.qtpselenium.hybrid.suitea;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.hybrid.base.BaseTest;
import com.qtpselenium.hybrid.util.DataUtil;


//name of the java file should be same as the name in xls file
public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void loginTest(Hashtable<String, String> data ) {
		
	//make sure that u have my prop and xls file objects
		//before test starts
	System.out.println("Running Login test");	
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		System.out.println("Inside data provider");
		return DataUtil.getTestData(testName, xls);
	}

}
