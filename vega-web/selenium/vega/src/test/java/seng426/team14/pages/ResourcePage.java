package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class ResourcePage extends Page {

    public ResourcePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResourcePage() {
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[4]")
    public WebElement resourceTab;

    @FindBy(xpath = "//*[@id=\"resource-upload\"]")
    public WebElement fileSelection;

    @FindBy(xpath = "//*[@id=\"resource-upload-submit-button\"]")
    public WebElement submitButton;

    public void clickOnResouceTab(){
        webActions.clickOn(resourceTab);
    }

    public void clickOnSubmit(){
        webActions.clickOn(submitButton);
    }

    public void isResourceTabDisplayed(){
        Util.isWebElementVisible(this.driver, this.resourceTab);
    }

    public void isFileSelectionDisplayed(){
        Util.isWebElementVisible(this.driver, this.fileSelection);
    }

    public void isSubmitDisplayed(){
        Util.isWebElementVisible(this.driver, this.submitButton);
    }

    public void fileSelectionDisabled(){
        Util.verifyCurrentUrl("http://localhost:3000/resources");
    }
    public void resourceTabDisabled(){
        Util.verifyCurrentUrl("http://localhost:3000");
    }
}