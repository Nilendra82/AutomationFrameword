package com.flipkart.stepdefinitions;

import com.flipkart.test.BaseIntegration;
import com.flipkart.test.InitializeBrowser;

import cucumber.api.java.en.Given;

public class FlipKartStepdefinitions extends BaseIntegration{
	@Given("^This is cucumber test$")
	public void test() throws Exception {
		
		String browserName = InitializeBrowser.getBrowserName();
		System.out.println(browserName);
		setWebDriver(browserName);
	}
}
