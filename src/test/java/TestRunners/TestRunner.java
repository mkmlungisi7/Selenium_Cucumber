package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Rerun failed tests from rerun.txt file
        features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:Reports/cucumber-reports/Cucumber.json",
                "junit:Reports/cucumber-reports/Cucumber.xml",
                "html:Reports/cucumber-reports/report.html",
                "rerun:Reports/cucumber-reports/rerun.txt"
        },
        monochrome = true
)
public class TestRunner {
}
