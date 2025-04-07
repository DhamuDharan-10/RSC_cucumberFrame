package com.Hooks.org.rsc_Ecom;



import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Base.Rsc_Ecom.Utilites;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;




public class Hooks {
	
	Utilites utilis = Utilites.getSingle();
	static WebDriver driver;
	
	@Before
	public void ApplicationLaucher(Scenario scenario) {
		utilis.BrowserLaucher();
		driver = Utilites.driver;
		final byte[] image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(image, "image/png");
	}
	@After
	public void tearDown(Scenario scenario) {
		byte[] image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(image, "image/png");
		utilis.BrowserClose();
	}

}
