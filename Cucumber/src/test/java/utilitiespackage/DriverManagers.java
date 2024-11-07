 package utilitiespackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManagers {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
        	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\KSC\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
                ChromeOptions opt=new ChromeOptions();
                opt.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(opt);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
