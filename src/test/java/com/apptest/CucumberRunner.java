package com.apptest;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
/*
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-report.html" }, features = {
		"src/test/resources" }, glue = { "com.apptest.steps" })*/


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "pretty", "html:reports/Cucumber-report_.html" },
        glue = {"com/apptest/steps"},
        features = "src/test/resources/features",
        publish = true,
        monochrome = true
)



public class CucumberRunner {

	
}
