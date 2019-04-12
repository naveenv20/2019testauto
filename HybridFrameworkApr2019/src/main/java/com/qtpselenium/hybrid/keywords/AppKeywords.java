package com.qtpselenium.hybrid.keywords;

import com.aventstack.extentreports.Status;

public class AppKeywords extends GenericKeywords{

	
	
	public void validateLogin()  {
		test.log(Status.INFO,"Inside the validate login function");	
	}
	
	public void defaultlogin() {
		test.log(Status.INFO,"Inside the default login function");	
	}
}
