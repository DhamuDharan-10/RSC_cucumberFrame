package org.TestRunner.Rsc_Ecom;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".\\src\\test\\resources\\Features",
                  glue ={"org.Rsc_Ecom"},
                  tags = "@smoke",
                  monochrome = true,
                  dryRun = false,
                  plugin = {"html:target/cucumber/cucumber-report.html","json:target/cucumber/cucumber-report.json"})
public class TestRunner {

}
