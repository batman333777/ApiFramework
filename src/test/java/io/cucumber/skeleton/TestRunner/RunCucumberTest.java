package io.cucumber.skeleton.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html",
        "junit:target/MyReports/report.xml",
        "json:target/MyReports/report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources",
        tags = "@AddPlace or @DeletePlace",
        glue = "io.cucumber.skeleton",
        publish = true,
        monochrome = true)
public class RunCucumberTest {
}
