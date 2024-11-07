package utilitiespackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestStep;

public class ExtentReport {

    private static ExtentReports extent;
    private static ExtentTest scenarioTest;
    private static ExtentTest stepTest;

    @Before
    public void setUp(Scenario scenario) {
        // Initialize Extent Report if it's not initialized already
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/spark-extent-report.html");
            sparkReporter.config().setDocumentTitle("Cucumber Extent Report");
            sparkReporter.config().setReportName("BDD Test Report");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        // Create a new test for each scenario
        scenarioTest = extent.createTest(scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        // Create a sub-log for each step
        stepTest = scenarioTest.createNode("Executing Step: " + scenario.getStatus());
     
        
        
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Log the result of the step in the report
        if (scenario.isFailed()) {
            stepTest.log(Status.FAIL, "Step failed: " + scenario.getStatus());
  
        } else {
            stepTest.log(Status.PASS, "Step passed: " + scenario.getStatus());
      
        }
    }
    

    @After
    public void tearDown(Scenario scenario) {
        // Mark the scenario as passed or failed in the report
        if (scenario.isFailed()) {
            scenarioTest.log(Status.FAIL, "Scenario Failed");
        } else {
            scenarioTest.log(Status.PASS, "Scenario Passed");
        }
        extent.flush(); // Save the report after each scenario
    }
    
    
    
    public void logStepToReport(TestStep step, Result result) {
        if (step instanceof PickleStepTestStep) {
            PickleStepTestStep pickleStep = (PickleStepTestStep) step;
            String stepText = pickleStep.getStep().getText();  // Fetch step text from the feature file
            
            // Log step text and status in Extent Report
            scenarioTest.log(Status.INFO, stepText);
        }
        
        
        
        
        
        
        
    }
}



