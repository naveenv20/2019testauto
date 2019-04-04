package com.qtpselenium.hybrid.keywords;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeywords {
	
	public Properties envProp;
	public Properties prop;
	public String objectkey;
	public String datakey;
	public Hashtable<String, String> data;
		
	/*******************Getter and setter***************************/

	public Properties getEnvProp() {
		return envProp;
	}

	public void setEnvProp(Properties envProp) {
		this.envProp = envProp;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public String getObjectkey() {
		return objectkey;
	}

	public void setObjectkey(String objectkey) {
		this.objectkey = objectkey;
	}

	public String getDatakey() {
		return datakey;
	}

	public void setDatakey(String datakey) {
		this.datakey = datakey;
	}

	public Hashtable<String, String> getData() {
		return data;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	
	/**********************************************/
	public void openBrowser() {
		System.out.println("open browser"+ data.get(datakey));
		
	}
	
	public void click() {
		System.out.println("click"+ prop.getProperty(objectkey));
		
	}
	
	
	public void type() {
		System.out.println("type on object: "+ prop.getProperty(objectkey)+"   and value is"+data.get(datakey));
	}
	
	public void navigate() {
		System.out.println("navigate"+ envProp.getProperty(objectkey));
	}
}
