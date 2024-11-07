package Runnerclass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "C:\\Users\\KSC\\git\\repository\\Cucumber\\src\\test\\resources\\Features file",  // Path to your feature files
    glue = {"StepDefinationfile","utilitiespackage"},                // Package containing step definitions
    plugin = {"pretty"},
    monochrome = true,                          
    dryRun = false           
)
public class Runnerclass {
}
