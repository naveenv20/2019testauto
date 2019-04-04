package com.qtpselenium.hybrid.driver;

import java.util.Hashtable;
import java.util.Properties;

import com.qtpselenium.hybrid.keywords.AppKeywords;
import com.qtpselenium.hybrid.util.Xls_Reader;

public class DriverScript {

	
	public Properties envProp;
	public Properties prop;
	AppKeywords app;



public void executeKeywords (String testName, Xls_Reader xls, Hashtable<String, String> data) {
	int rows=xls.getRowCount("Keywords");
System.out.println("num of rows "+ rows);

app=new AppKeywords();
//send properties to keywords class
app.setEnvProp(envProp);
app.setProp(prop);
//send the hashtable data aswell to keywords class
app.setData(data);
for(int rNum=2;rNum<=rows;rNum++) {
String tcid=xls.getCellData("Keywords", "TCID", rNum);
if(tcid.equals(testName)) {
String keyword=xls.getCellData("Keywords", "Keyword", rNum);
String objectkey=xls.getCellData("Keywords", "Object", rNum);
String datakey=xls.getCellData("Keywords", "Data", rNum);
String datavalue=data.get(datakey);
//System.out.println(tcid+"--"+keyword+"--"+objectkey+"--"+datakey+"--"+datavalue+"--");
//System.out.println("Object key has the value as : "+prop.getProperty(objectkey));


app.setDatakey(datakey);
app.setObjectkey(objectkey);


if(keyword.equals("openBrowser")) {
	app.openBrowser();
}

else if(keyword.equals("navigate")) {
	app.navigate();
}

else if(keyword.equals("input")) {
	app.type();
}

else if(keyword.equals("click")) {
	app.click();
}

}
}
}




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
	

}
