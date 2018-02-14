package com.flipkart.test;

import java.io.FileReader;
import java.util.Properties;

public class FlipkartProperties {
	public static String value=null;
	public static String getPropertiesValue(String key) {
		try {
			FileReader reader=new FileReader("src/test/resources/application.properties");  
		      
		    Properties p=new Properties();  
		    p.load(reader);  
		    value = p.getProperty(key);  
		    System.out.println(value);  
		   // System.out.println(p.getProperty("password"));  
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return value;
	}
}
