package seng426.team14.utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Util {

    private static int ScreenShotIterator = 1;


    // check if a piece of text exists in the webpage
    public static boolean checkText(WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
        By byText = By.xpath("//*[normalize-space()='" + text + "']");
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(byText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // check if a piece of text does not exist in the webpage
    public static boolean checkNoText(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
            By byText = By.xpath("//*[text()='" + text + "']");
            wait.until(ExpectedConditions.invisibilityOfElementLocated(byText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // make thread sleep for a specific time(second unit)
    public static void sleep(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * compare two unordered list
     */
    public static boolean CompareUnorderedList(List<String> ExcelData, List<String> UIData) {
        boolean result = false;
        for (int i = 0; i < UIData.size(); i++) {
            for (int j = 0; j < ExcelData.size(); j++) {
                result = UIData.get(i).equals(ExcelData.get(j));

                if (result == true) {
                    break;
                }
            }
        }
        return result;

    }

    /*
     * verify the text within a web element
     */
    public static void VerifyElement(WebDriver driver, WebElement element, String expectedVal) {
        try {
            boolean check = false;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
            wait.until(ExpectedConditions.visibilityOf(element));
            String actualValue = element.getText().trim().replaceAll("\u00A0", " ");
            String expectedValue = expectedVal.trim();
            check = actualValue.contains(expectedValue);
            Assert.assertEquals(check, "Expected and Actual values doesnot match");

        } catch (Exception e) {
            throw e;
        }
    }

    /*
     * verify the current URL with an expected one
     */
    public static boolean VerifyURL(String expectedURL) throws MalformedURLException {
        boolean check;
        try {
            URL expectedUrl = new URL(expectedURL);
            System.out.println(expectedURL);
            URL actualUrl = webActions.GetCurrentPageURL();
            System.out.println(actualUrl);
            String expected = expectedUrl.toString();
            String actual = actualUrl.toString();
            check = actual.contains(expected);
            Assert.assertTrue(check);
            if (check != true) {
                throw new MalformedURLException("Incorrect Url Loaded, Expected URL is different from Actual URL");
            }
            return check;
        } catch (MalformedURLException ex) {
            throw ex;
        }
    }


    /*
     * This method captures value of webelement
     */
    public static String CaptureValue(WebDriver driver, WebElement element) {
        String elementValue = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
            wait.until(ExpectedConditions.visibilityOf(element));
            elementValue = element.getText();
            System.out.println("capturedValue: " + elementValue);
        } catch (Exception e) {
            throw e;
        }
        return elementValue;
    }

    /**
     * This method verifies the current URL with the input URL.
     *
     * @param expectedURL
     * @return true if the two URLs are equal, false otherwise. if the current URL does not exist, return false.
     * @author MU4S
     */
    public static boolean verifyCurrentUrl(URL expectedURL) {
        return verifyCurrentUrl(expectedURL.toString());
    }

    /**
     * overload method for verifyCurrentUrl(URL expectedURL).
     *
     * @param expected
     * @return true if the two URLs are equal, false otherwise. if the current URL does not exist, return false.
     * @author MU4S
     */
    public static boolean verifyCurrentUrl(String expected) {
        // URL currentURL = new URL(DriverFactory.getInstance().getDriver().getCurrentUrl());
        URL currentURL = webActions.GetCurrentPageURL();
        String current = currentURL.toString();
        return (current.equals(expected)) ? true : false;
    }

    /**
     * compare two urls whether they are equal.
     *
     * @param expectedURL
     * @param actualURL
     * @return return true if they are equal, false otherwise.
     * @author MU4S
     */
    public static boolean compareTwoUrls(URL expectedURL, URL actualURL) {
        String expected = expectedURL.toString();
        String actual = actualURL.toString();
        return (actual.equals(expected)) ? true : false;
    }

    /**
     * verify if a web element exists on the current web page.
     *
     * @param driver
     * @param webElement
     * @return true if element is visible, and false if element is invisible. if the element cannot be found, return false.
     * @author MU4S
     */
    public static boolean isWebElementVisible(WebDriver driver, WebElement webElement) {
        try {
//			return webElement.isDisplayed();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    /**
     * check whether a web element (eg. checkbox, an option from dropdown) is selected.
     *
     * @param driver
     * @param locator
     * @return return true if the element is selected, false otherwise. if the element cannot be found, return false as well.
     * @author MU4S
     */
    public static boolean isWebElementSelected(WebDriver driver, By locator) {
        try {
            return (driver.findElement(locator).isSelected()) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * overload method for isWebElementSelected(WebDriver driver, By locator).
     *
     * @param webElement
     * @return return true if the element is selected, false otherwise. if the element cannot be found, return false as well.
     * @author MU4S
     */
    public static boolean isWebElementSelected(WebElement webElement) {
        try {
            return (webElement.isSelected()) ? true : false;
        } catch (Exception e) {
            return false;
        }
    }

}