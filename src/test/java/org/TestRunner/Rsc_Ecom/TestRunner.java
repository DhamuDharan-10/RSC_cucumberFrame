package org.TestRunner.Rsc_Ecom;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;





@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Features",
                  glue ={"org.Rsc_Ecom","com.Hooks.org.rsc_Ecom"},
                  tags = "@smoke",
                  monochrome = true,
                  dryRun = false,
                  plugin = {"html:target/html.report","json:target/cucumber-report.json"})


public class TestRunner {

}
