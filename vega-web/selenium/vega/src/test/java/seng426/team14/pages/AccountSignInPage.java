package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class AccountSignInPage extends Page{
    public AccountSignInPage(WebDriver driver){
        super(driver);
    }

    public AccountSignInPage(){
        super();
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[7]")
    public WebElement adminTab;

    @FindBy(xpath = "//*[@id=\"login-username-input\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"login-submit-button\"]")
    public WebElement submit;
    public void isAdminTabDisplayed(){
        Util.isWebElementVisible(this.driver, adminTab);
    }

    public  void clickOnSubmit(){
        webActions.clickOn(submit);
    }

    public void loginAsAdmin(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        this.clickOnSubmit();
    }
}
