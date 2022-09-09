package com.apptest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:reports/Cucumber-report.html" },
        glue = {"com/apptest/steps"},
        features = "src/test/resources/features",
        publish = true,
        monochrome = true
)



public class CucumberRunner {

	
}
