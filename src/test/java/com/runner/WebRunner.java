package com.runner;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Features" }, glue = "com.stepdefinition", 
		strict = true, monochrome = true, dryRun=false,
		plugin = {"json:target\\cucumber.json"},tags= {"@test2"}
		)

public class WebRunner extends AbstractTestNGCucumberTests{
	@DataProvider(parallel = false)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	

}
