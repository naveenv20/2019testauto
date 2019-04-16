package com.qtpselenium.hybrid.keywords;

import com.aventstack.extentreports.Status;

public class AppKeywords extends GenericKeywords{

	
	
	public void validateLogin()  {
		test.log(Status.INFO,"Inside the validate login function");	
		if(isElementPresent("logout_xpath")){
			test.log(Status.INFO,"Login Success");	
		}
		else{
			test.log(Status.INFO,"Not able to login");
			reportFailure("Login Failed");
		}
		
	}
	
	public void defaultlogin() {
		test.log(Status.INFO,"Inside the default login function");	
	}
}
