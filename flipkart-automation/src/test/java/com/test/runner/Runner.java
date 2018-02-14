package com.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class Runner {
	@CucumberOptions(
	        format={"pretty","json:path/to/json_repot.json"},
	        features = "src/test/resources/features",
	        glue="com.flipkart.stepdefinitions",
	        tags={"@Login"}
	        )
	public class TestRunner extends AbstractTestNGCucumberTests{}
}
