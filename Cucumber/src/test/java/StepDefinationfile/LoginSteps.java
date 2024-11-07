package StepDefinationfile;

import java.io.File;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilitiespackage.Assertionsmethods;
import utilitiespackage.DriverManagers;
import POMpages.SignIn_page;


public class LoginSteps {
	

  WebDriver driver;
  SignIn_page signInpage;
//Hooks
  @Before
  public void setUp() {
      driver = DriverManagers.getDriver();
      signInpage = new SignIn_page(driver);
  }
  @After
  public void tearDown() {
     DriverManagers.quitDriver();
  }
	  /*@After
	    public void afterScenario(io.cucumber.java.Scenario scenario) {
	        if (scenario.isFailed()) {
	            // Take a screenshot when the scenario fails
	            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            try {
	                FileUtils.copyFile(screenshot, new File("C:\\Users\\KSC\\eclipse-workspace\\Cucumber\\screenshots" + scenario.getName() + ".png"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	              }
  
	  }*/
//	  public void tearDown() {
//		      DriverManagers.quitDriver();
//	  }
  
 
  

    @Given("user is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
       
        driver.get("https://qa-app.unihire.live/auth/signin");
       
    }
    
    
    
    

@When("user enters username as {string}")
public void user_enters_username_as(String username) {
	signInpage.enterUsername(username);
	
}
@When("Click on Signin button in enter email page")
public void Click_on_Signin_button() {
	signInpage.emailsigninbth_click();
}

@When("Enter otp as {string}")
public void enter_otp_as(String otp) {
	signInpage.enterpwd(otp);
}

@When("Click on Sign In button")
public void click_on_sign_in_button() {
	signInpage.otpsign_in();
}

    @Then("user should be redirected to the homepage")
    public void user_should_be_redirected_to_the_homepage() throws InterruptedException {
    	Thread.sleep(2000);
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assertionsmethods.assertEquals("https://qa-app.unihire.live/customer/dashboard", url);
       // .assertEquals("https://qa-app.unihire.live/customer/dashboard", url);
        
    
        }
 // Scenario: User doenot exist message should display when tries to register with not registed mail
    @Then("Validation error message should dsipay")
    public void validation_error_message_should_dsipay() {
    	String text=signInpage.getText();
    	System.out.println(text);
    	 Assertionsmethods.assertEquals("Please sign up, your account does not exist", text);
        
    }   
    }

