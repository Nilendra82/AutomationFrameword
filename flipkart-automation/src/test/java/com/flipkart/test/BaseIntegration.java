package com.flipkart.test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.log4testng.Logger;

public class BaseIntegration {
	private static Logger logger = Logger.getLogger(BaseIntegration.class);
	public static WebDriver driver;
	private static String CHROMEDRIVER = "/exe/chromedriver.exe";
	private static String IEDRIVER = "/exe/IEDriverServer.exe";
	private static String PHANTOMJSDRIVER_WIN = "/phantomjs/bin/phantomjs.exe";
	private static String ADDWORKINFOFILEPATH = "/file_uploads/Test5.jpg";
	public static String fp = null;
	public static ArrayList<String> cliArgsCap;
	
	public void setWebDriver(String browser) throws Exception
    {
    	if (browser.equalsIgnoreCase("Firefox")) 
    	{
    		logger.info("####### Launching Firefox #######");
    		driver = new FirefoxDriver();
    	}

   	    else if (browser.equalsIgnoreCase("Chrome")) 
   	    {
   		   	logger.info("####### Launching Chrome #######");
   		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("disable-infobars"); 
   		   	DesiredCapabilities capabilities = DesiredCapabilities.chrome ();       
   		    capabilities.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
   		    capabilities.setCapability(ChromeOptions.CAPABILITY, options); 
   		   	System.setProperty("webdriver.chrome.driver", BaseIntegration.class.getResource(CHROMEDRIVER).getFile());
   		   	
   		    driver = new ChromeDriver(capabilities);
   		} 
   	    else if (browser.equalsIgnoreCase("IE")) 
   	    {
    		logger.info("####### Launching IE #######");
   	    	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
   	    	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
   	    	capabilities.setCapability("ignoreZoomSetting", true);
   	    	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   	    	System.setProperty("webdriver.ie.driver", BaseIntegration.class.getResource(IEDRIVER).getFile());
   	    	driver = new InternetExplorerDriver(capabilities);
   	    }
   	    else if(browser.equalsIgnoreCase("PhantomJSWin"))
   	    {
   	    	logger.info("############### USING PHANTOM DRIVER in Windows ##############");
   	    	cliArgsCap = new ArrayList<String>();
   	    	DesiredCapabilities caps = DesiredCapabilities.phantomjs();
   	    	cliArgsCap.add("--web-security=false");
   	    	cliArgsCap.add("--ssl-protocol=any");
   	    	cliArgsCap.add("--ignore-ssl-errors=true");
   	    	caps.setCapability("takesScreenshot", true);
   	    	caps.setCapability(
   	    	    PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
   	    	caps.setCapability(
   	            PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
   	            BaseIntegration.class.getResource(PHANTOMJSDRIVER_WIN).getFile());
   	    	driver = new PhantomJSDriver(caps);
   	    	
   	    	//System.setProperty("phantomjs.binary.path", BaseIntegration.class.getResource(PHANTOMJSDRIVER_WIN).getFile());       
   	    }
   	   	String url = FlipkartProperties.getPropertiesValue("url"); 
    	driver.get(url);
    	driver.manage().window().maximize();
    }
}
