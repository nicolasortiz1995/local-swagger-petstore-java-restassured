package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Test runner class for executing Cucumber tests using TestNG.
 * This class is configured with Cucumber options to specify feature files, step definitions,
 * and plugins.
 */
@CucumberOptions(
        features = "src/test/java/features",
        glue = "steps",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}