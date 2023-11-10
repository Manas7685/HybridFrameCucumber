package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


	@CucumberOptions
	(features="src/test/resources/features",
	glue={"com/stepdefinitions","src/main/java/com/frmbase"},
	dryRun=true)
	public class MyTestsRunner extends AbstractTestNGCucumberTests {

	}
