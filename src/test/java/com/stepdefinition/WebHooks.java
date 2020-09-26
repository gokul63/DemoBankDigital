package com.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class WebHooks {

	private ScenarioContext context;

	public WebHooks(ScenarioContext context) {

		this.context = context;

	}

	@After
	public void endConnection(Scenario sc) {

		if(sc.isFailed())
		{
			TakesScreenshot t = (TakesScreenshot)context.getWebDriverValue();
			byte[] screenshotAs = t.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, "Failure/png", "TestCaseFailed");
			
		}
		else {
			TakesScreenshot t = (TakesScreenshot)context.getWebDriverValue();
			byte[] screenshotAs = t.getScreenshotAs(OutputType.BYTES);
			sc.embed(screenshotAs, "Pass/png", "TestCasePassed");
		
		}
		
		context.getWebDriverValue().quit();
	}

}
