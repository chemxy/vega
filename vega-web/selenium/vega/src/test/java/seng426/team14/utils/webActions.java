package seng426.team14.utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class webActions {

    WebDriver driver = DriverFactory.getInstance().getDriver();


    public static void scrollIntoView(WebElement element) {

        WebDriver driver = DriverFactory.getInstance().getDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            waitForLoad(driver);
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
        }

    }

    public static void scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();

        try {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
        }
    }


    /*	This method will check if the element is present and then enters
     * the specified text in the element - Generic method for sendKeys()
     * If the element is not found, the current Test case will fail, however, the other
     * cases will still continue
     */
    public static void setText(WebElement element, String text) {
        try {
            webActions.clickOn(element);
            element.clear(); // change: added this line by MU4S
            element.sendKeys(text);
        } catch (NoSuchElementException ne) {

            Assert.fail(ne.getMessage());
        }
    }

    public static void selectListBoxValue(WebElement listbox, String value) {

        Select select = new Select(listbox);
        select.selectByVisibleText(value);
    }

    /*	This method will check if the element is present and then clicks
     * on the element
     * If the element is not found, the current Test case will fail, however, the other
     * cases will still continue
     */
    public static void clickOn(WebElement element) {
        try {
            webActions.waitForElementToBeClickable(DriverFactory.getInstance().getDriver(), element);
            element.click();

        } catch (NoSuchElementException ne) {

            Assert.fail(ne.getMessage());
        }
    }


    /*	This method will select the specified text from the dropdown.
     * Please note that this dropdown is for <li>/<ul> type of dropdown
     * If any element is not found, the current Test case will fail, however, the other
     * cases will still continue
     */
    public static void selectTextFromDropdown(WebElement dropDown, List<WebElement> options, String text)
            throws InterruptedException {
        try {
            dropDown.click();

            for (WebElement option : options) {
                if (text.equalsIgnoreCase(option.getText()))
                    option.click();

            }

        } catch (NoSuchElementException ne) {
            Assert.fail(ne.getMessage());
        }

    }

    public static boolean checkText(WebDriver driver, String text) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
            By byText = By.xpath("//*[text()='" + text + "']");
            wait.until(ExpectedConditions.visibilityOfElementLocated(byText));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //wait for webpage to be fully loaded
    public static void waitForLoad(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
        try {
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        } catch (JavascriptException e) {
        }
    }

    /*	This method will wait for the element/conditions upto a maximum of 3 minutes,
     * however, the conditions will be checked every 250 ms, if found the test will
     * continue
     */
    public static boolean waitForElementToBeClickable(WebDriver driver, WebElement element) {
        scrollIntoView(element);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            Assert.fail("Waited for " + element + "Failing the testcase" + e.getMessage());
            return false;
        }
    }

    /*
     * wait until the element is visible
     */
    public static boolean waitForElementToBeVisible(WebDriver driver, WebElement element) {
        scrollIntoView(element);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            throw e;
        }
        return element.isEnabled();
    }

    /**
     * wait until the element is invisible.
     *
     * @param driver
     * @param element
     * @return
     * @author MU4S
     */
    public static boolean waitForElementToBeInvisible(WebDriver driver, WebElement element) {
        scrollIntoView(element);
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constant.WAIT_TIME));
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception e) {
            throw e;
        }
        return true;
    }


    /*
     * KeyPress will take a list of KeyEvent Integers (e.g. KeyEvent.VK_ALT, KeyEvent.VK_F)
     * and will press them in order, and release them in reverse order.
     *
     * Example: webActions.keyPress(Arrays.asList(KeyEvent.VK_ALT, KeyEvent.VK_TAB))
     *
     * @author 	Jory Anderson
     * @throws 	AWTException if inputs are not KeyEvent integer class variables
     */
    public static void KeyPress(List<Integer> keys) throws AWTException {
        Stack<Integer> keyReleaseStack = new Stack<Integer>();
        Robot robot = new Robot();

        for (Integer key : keys) {
            robot.keyPress(keyReleaseStack.push(key));
        }

        while (!keyReleaseStack.isEmpty()) {
            robot.keyRelease(keyReleaseStack.pop());
        }

    }

    /*
     * THis method will simulate the paste of a String
     */
    public static void KeyPress_String(String text) throws AWTException {
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    /*
     * This method will check if any Alert pop up is displayed,
     * If displayed, it will accept and dismiss the alert
     */
    public static void dismissAlertBox() {

        WebDriver driver = DriverFactory.getInstance().getDriver();

        try {
            // Alert alert = driver.switchTo().alert();
            // System.out.println(alert.getText()+" Alert is Displayed");
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        } catch (NoAlertPresentException ex) {
        }
    }

    /*
     * This method will switch the driver control from one window to another
     */
    public static void switchWindow() {

        WebDriver driver = DriverFactory.getInstance().getDriver();

        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }

    }

    public static void closeAllButCurrentWindow() {

        WebDriver driver = DriverFactory.getInstance().getDriver();

        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.close();
                driver.switchTo().window(parentWindow);
            }
        }

    }

    public static URL GetCurrentPageURL() {
        URL urL = null;
        try {
            urL = new URL(DriverFactory.getInstance().getDriver().getCurrentUrl());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return urL;
    }


}
