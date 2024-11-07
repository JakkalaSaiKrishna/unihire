package utilitiespackage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicMethods {
	

//1.1	
	public static void click(WebDriver driver, By locator) {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(locator));
		button.click();
		}
		
			catch (Exception e) {
		        System.out.println("Exception occurred while waiting for element to be clickable: " + e.getMessage());
		}
		*/
		WebElement a=BasicMethods.waitForElementToBeClickable(driver, locator, 10);
		a.click();
		

	    
	   /* try {
	        WebElement element = driver.findElement(locator);
	        element.click();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while clicking element: " + e.getMessage());
	    }*/
	}
//1.2
	public static void sendKeys(WebDriver driver, By locator, String inputText) {
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		inputField.sendKeys(inputText);
		}
		catch (Exception e) {
	        System.out.println("Exception occurred while waiting for element to be visible: " + e.getMessage());
		}*/
		
		WebElement a=BasicMethods.waitForElementToBeVisible(driver, locator, 10);
		a.sendKeys(inputText);
		
		
		
	  /* try {
	        WebElement element = BasicMethods.waitForElementToBeVisible(driver,locator, 20);
	      
	        element.sendKeys(inputText);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while sending keys: " + e.getMessage());
	    }*/
	}
//1.3
	public static WebElement findElement(WebDriver driver, By locator) {
	    try {
	        return driver.findElement(locator);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while finding element: " + e.getMessage());
	        return null;
	    }
	}
//1.4
	public static List<WebElement> findElements(WebDriver driver, By locator) {
	    try {
	        return driver.findElements(locator);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while finding elements: " + e.getMessage());
	        return new ArrayList<>();
	    }
	}
//1.5
	public static WebElement waitForElementToBeClickable(WebDriver driver, By locator, int timeoutInSeconds) {
		
		
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	         return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    } catch (Exception e) {
	        System.out.println("Exception occurred while waiting for element to be clickable: " + e.getMessage());
	       return null;
	    }
	}

//1.6
	public static WebElement waitForElementToBeVisible(WebDriver driver, By locator, int timeoutInSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    } catch (Exception e) {
	       System.out.println("Exception occurred while waiting for element to be visible: " + e.getMessage());
	      return null;
	    }
	}
//1.7
	public static WebElement waitForElementPresence(WebDriver driver, By locator, int timeoutInSeconds) {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    } catch (Exception e) {
	        System.out.println("Exception occurred while waiting for presence of element: " + e.getMessage());
	        return null;
	    }
	}
//1.8
	public static String getElementText(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        return element.getText();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while getting text: " + e.getMessage());
	        return null;
	    }
	}
//1.9
	public static String getElementAttribute(WebDriver driver, By locator, String attribute) {
	    try {
	        WebElement element = driver.findElement(locator);
	        return element.getAttribute(attribute);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while getting attribute: " + e.getMessage());
	        return null;
	    }
	}

//1.10
	public static boolean isElementDisplayed(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        return element.isDisplayed();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while checking element display: " + e.getMessage());
	        return false;
	    }
	}
//1.11
	public static boolean isElementEnabled(WebDriver driver, By locator) {
	    try {
	        WebElement element = driver.findElement(locator);
	        return element.isEnabled();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while checking if element is enabled: " + e.getMessage());
	        return false;
	    }
	}
//1.12
	public static void selectDropdownByVisibleText(WebDriver driver, By locator, String visibleText) {
	    try {
	        WebElement dropdownElement = driver.findElement(locator);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByVisibleText(visibleText);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while selecting from dropdown: " + e.getMessage());
	    }
	}
//1.13
	public static void switchToFrame(WebDriver driver, By locator) {
	    try {
	        WebElement iframe = driver.findElement(locator);
	        driver.switchTo().frame(iframe);
	    } catch (Exception e) {
	        System.out.println("Exception occurred while switching to frame: " + e.getMessage());
	    }
	}

//1.14
	public static void switchToDefaultContent(WebDriver driver) {
	    try {
	        driver.switchTo().defaultContent();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while switching back to default content: " + e.getMessage());
	    }
	}
//1.15
	public static void acceptAlert(WebDriver driver) {
	    try {
	        Alert alert = driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	        System.out.println("Exception occurred while accepting alert: " + e.getMessage());
	    }
	}
//1.16
	public static void scrollToElement(WebDriver driver, By locator) {
	    WebElement element = driver.findElement(locator);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
//1.17
	

	

}
