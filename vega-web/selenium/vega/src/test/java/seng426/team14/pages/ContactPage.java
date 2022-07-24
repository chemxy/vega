package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class ContactPage extends Page {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage() {
        super();
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[6]")
    public WebElement contactTab;

    @FindBy(xpath = "//*[@id=\"user-registration-name-input\"]")
    public WebElement nameField;

    @FindBy(xpath = "//*[@id=\"user-registration-email-input\"]")
    public WebElement emailField;

    @FindBy(xpath = "//*[@id=\"user-registration-message-input\"]")
    public WebElement messageField;

    @FindBy(xpath = "//*[@id=\"user-registration-submit-button\"]")
    public WebElement submitButton;

    public void clickOnContactTab(){
        driver.get("http://localhost:3000/contactus");
    }

    public void areFieldsDisplayed(){
        Util.isWebElementVisible(this.driver, this.nameField);
        Util.isWebElementVisible(this.driver, this.emailField);
        Util.isWebElementVisible(this.driver, this.messageField);
        Util.isWebElementVisible(this.driver, this.submitButton);
    }

    public void sendText(){
        webActions.setText(this.nameField, "testName");
        webActions.setText(this.emailField, "testEmail");
        webActions.setText(this.messageField, "testMessage");
    }

    public void clickOnSubmit(){
        webActions.clickOn(submitButton);
    }

}