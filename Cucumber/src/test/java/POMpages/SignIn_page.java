package POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilitiespackage.*;

public class SignIn_page {

    private WebDriver driver;

    // Locators for the Login page elements
    private By email =By.xpath("//input[@name='email']");
    private By emailsigninbtn = By.xpath("//button[text()='Sign in']");
    private By otp =By.xpath("//input[@type='text']");
    private By otpsignin = By.xpath("//button[text()='Sign in']");
    private By errormsg = By.xpath("//div[text()='Please sign up, your account does not exist']");

    // Constructor to initialize the WebDriver
    public SignIn_page(WebDriver driver) {
        this.driver = driver;
    }

    // Page actions (methods)
    public void enterUsername(String username) {
    	BasicMethods.sendKeys(driver, email, username);
    	System.out.println("username entered");
    }

    public void emailsigninbth_click() {
        BasicMethods.click(driver, emailsigninbtn);
        System.out.println("emailsigninbth_click");
    }

    public void enterpwd(String password) {
    	BasicMethods.sendKeys(driver, otp, password);
    	System.out.println("enterpwd");
    }

    public void otpsign_in() {
    	 BasicMethods.click(driver, otpsignin);
    	 System.out.println("otpsign_in");
    }
    public String getText() {
    	BasicMethods.waitForElementToBeVisible(driver, otp, 10);
    	return BasicMethods.getElementText(driver,errormsg);
    }
}
