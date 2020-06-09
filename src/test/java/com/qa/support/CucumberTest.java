package com.qa.support;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                glue = {"com.qa.support.stepdef"},
                features = {"classpath:features"},
                plugin = {"pretty", "html:target/cucumber", "json:target/cucumber-report.json"},
                strict = true)
public class CucumberTest {
}