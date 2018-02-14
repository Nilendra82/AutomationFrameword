package com.flipkart.test;

import org.testng.log4testng.Logger;

public class InitializeBrowser {
	private static Logger logger = Logger.getLogger(InitializeBrowser.class);
	private final static String TEST_BROWSER = "TEST_BROWSER";
	private final static String TEST_PLATFORM = "TEST_PLATFORM";
	public static String getBrowserName() {
		String browser = null;
		/*if(System.getProperty(TEST_BROWSER).equalsIgnoreCase("Firefox"))
 	    {
			browser = "Firefox";
 		}
		else if(System.getProperty(TEST_BROWSER).equalsIgnoreCase("Chrome"))
 	    {
			browser = "Chrome";
 		}
		else if(System.getProperty(TEST_BROWSER).equalsIgnoreCase("IE"))
 	    {
			browser = "ie";
 		}
		else if(System.getProperty(TEST_PLATFORM).equalsIgnoreCase("WIN") &&
				System.getProperty(TEST_BROWSER).equalsIgnoreCase("PhantomJS"))  {
			
			browser = "PhantomJSWin";
 		}
		else
		{
			logger.info("Please use Firefox/Chrome/IE/PhantomJSWin/only");
		}*/
		
		browser = FlipkartProperties.getPropertiesValue("browser");
		System.out.println(browser);
		return browser;
	}
}
