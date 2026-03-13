package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features = ".//Features/Login.feature",
                glue = "stepdefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html:test-output"}

        )
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
