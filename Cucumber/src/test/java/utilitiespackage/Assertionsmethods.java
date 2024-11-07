package utilitiespackage;

import java.util.List;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

public class Assertionsmethods {

//equality
	    public static void assertEquals(Object expected, Object actual, String message) {
	        Assert.assertEquals(message, expected, actual);
	    }

	    public static void assertEquals(Object expected, Object actual) {
	        Assert.assertEquals(expected, actual);
	    }

	    public static void assertNotEquals(Object unexpected, Object actual, String message) {
	        Assert.assertNotEquals(message, unexpected, actual);
	    }

	    public static void assertNotEquals(Object unexpected, Object actual) {
	        Assert.assertNotEquals(unexpected, actual);
	    
	}
	    //boolean
	    public static void assertTrue(boolean condition, String message) {
	        Assert.assertTrue(message, condition);
	    }

	    public static void assertTrue(boolean condition) {
	        Assert.assertTrue(condition);
	    }

	    public static void assertFalse(boolean condition, String message) {
	        Assert.assertFalse(message, condition);
	    }

	    public static void assertFalse(boolean condition) {
	        Assert.assertFalse(condition);
	    }
	    // Assertion for Null/Not Null
	    public static void assertNull(Object object, String message) {
	        Assert.assertNull(message, object);
	    }

	    public static void assertNull(Object object) {
	        Assert.assertNull(object);
	    }

	    public static void assertNotNull(Object object, String message) {
	        Assert.assertNotNull(message, object);
	    }

	    public static void assertNotNull(Object object) {
	        Assert.assertNotNull(object);
	    }
	    // Assertion for Lists (or Collections)
	    public static void assertListEquals(List<?> expected, List<?> actual, String message) {
	        Assert.assertEquals(message, expected, actual);
	    }

	    public static void assertListEquals(List<?> expected, List<?> actual) {
	        Assert.assertEquals(expected, actual);
	    }

	    public static void assertListContains(List<?> list, Object value, String message) {
	        Assert.assertTrue(message, list.contains(value));
	    }

	    public static void assertListContains(List<?> list, Object value) {
	        Assert.assertTrue(list.contains(value));
	    }
	    //Assertion for String Matching
	    public static void assertStringContains(String fullText, String subText, String message) {
	        Assert.assertTrue(message, fullText.contains(subText));
	    }

	    public static void assertStringContains(String fullText, String subText) {
	        Assert.assertTrue(fullText.contains(subText));
	    }

	    public static void assertStringStartsWith(String fullText, String prefix, String message) {
	        Assert.assertTrue(message, fullText.startsWith(prefix));
	    }

	    public static void assertStringStartsWith(String fullText, String prefix) {
	        Assert.assertTrue(fullText.startsWith(prefix));
	    }

	    public static void assertStringEndsWith(String fullText, String suffix, String message) {
	        Assert.assertTrue(message, fullText.endsWith(suffix));
	    }

	    public static void assertStringEndsWith(String fullText, String suffix) {
	        Assert.assertTrue(fullText.endsWith(suffix));
	    }
	    //soft assersions
	    private static SoftAssert softAssert = new SoftAssert();

	    public static void softAssertEquals(Object expected, Object actual, String message) {
	        softAssert.assertEquals(actual, expected, message);
	    }

	    public static void softAssertTrue(boolean condition, String message) {
	        softAssert.assertTrue(condition, message);
	    }

	    public static void assertAll() {
	        softAssert.assertAll();  // Collect and report all failures
	    }

}
