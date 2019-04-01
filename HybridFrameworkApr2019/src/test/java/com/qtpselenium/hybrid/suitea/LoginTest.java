package com.qtpselenium.hybrid.suitea;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.hybrid.base.BaseTest;

public class LoginTest extends BaseTest{
	
	@Test(dataProvider="getData")
	public void loginTest(String x ) {
		
	//make sure that u have my prop and xls file objects
		//before test starts
	System.out.println();	
		
		
	}
	
	
	@DataProvider
	public Object[][] getData(){
		System.out.println("Inside data provider");
		Object[][]  data= new Object[1][1] ;
		data[0][0]="a";
		
		return data;
	}

}
