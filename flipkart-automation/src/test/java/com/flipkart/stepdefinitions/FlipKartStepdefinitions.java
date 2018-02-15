package com.flipkart.stepdefinitions;

import com.flipkart.test.BaseIntegration;
import com.flipkart.test.InitializeBrowser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class FlipKartStepdefinitions extends BaseIntegration{
	@Given("^This is cucumber test$")
	public void test() throws Exception {
		
		String browserName = InitializeBrowser.getBrowserName();
		System.out.println(browserName);
		setWebDriver(browserName);
	}
	@Given("^This is cucumber test2$")
	public void test2() throws Exception {
		
		System.out.println("Scenario 2");
	}
	@When("^put$")
	public void test3() {
		System.out.println("put");
	}
	@When("^this not done$")
	public void test4() {
		System.out.println("Scenario 4");
	}
}
