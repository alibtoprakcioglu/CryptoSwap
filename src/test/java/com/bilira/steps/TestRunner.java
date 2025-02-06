package com.bilira.steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features/",

		glue = "com.bilira.steps",

		dryRun = true,

		monochrome = true,

		tags = "Swap",

		plugin = {

				"pretty",
				// creates and saves the basic html report in the target folder
				"html:target/cucumber-default-report.html",
				// stores all executed steps in a json file
				"json:target/cucumber.json"

		}

)

public class TestRunner {

}
