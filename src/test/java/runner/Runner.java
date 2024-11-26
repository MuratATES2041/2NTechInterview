package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" // Allure reports
        },
        features = "src/test/resources/features",
        glue = {"stepDefinitions","hooks"},
        tags = "@wip",
        dryRun = false // true oldugunda sadece eksik adim var mi diye kontrol eder
)
public class Runner {
}
