package com.qtpselenium.hybrid.driver;

import java.util.Hashtable;
import java.util.Properties;

import com.qtpselenium.hybrid.util.Xls_Reader;

public class DriverScript {

	
	public Properties envProp;
	public Properties prop;
	



public void executeKeywords (String testName, Xls_Reader xls, Hashtable<String, String> data) {
	int rows=xls.getRowCount("Keywords");
System.out.println("num of rows "+ rows);


for(int rNum=2;rNum<=rows;rNum++) {
String tcid=xls.getCellData("Keywords", "TCID", rNum);
if(tcid.equals(testName)) {
String keyword=xls.getCellData("Keywords", "Keyword", rNum);
String objectkey=xls.getCellData("Keywords", "Object", rNum);
String datakey=xls.getCellData("Keywords", "Data", rNum);
String datavalue=data.get(datakey);
System.out.println(tcid+"--"+keyword+"--"+objectkey+"--"+datakey+"--"+datavalue+"--");
System.out.println("Object key has the value as : "+prop.getProperty(objectkey));


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
