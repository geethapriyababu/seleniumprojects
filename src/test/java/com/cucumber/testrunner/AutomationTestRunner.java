package com.cucumber.testrunner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src\\test\\resource\\com\\cucumber\\features\\AutomationPractice.feature",glue="com.cucumber.stepdefinition",dryRun=false,strict=true,monochrome=true		)


public class AutomationTestRunner {
	
	
	
}
