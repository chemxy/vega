package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class AdminPage extends Page {


    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage() {
        super();
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[7]")
    public WebElement adminTab;

    @FindBy(xpath = "//*[@id=\"admin-assign-role-dropbox\"]")
    public WebElement dropMenu;

    @FindBy(xpath = "//*[@id=\"admin-enable-user\"]")
    public WebElement enableButton;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/table/tbody/tr/td[1]")
    public WebElement userLabel;

    @FindBy(xpath = "//*[@id=\"login-username-input\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"login-submit-button\"]")
    public WebElement logIn;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a")
    public WebElement logOut;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[4]")
    public WebElement resourceTab;

    @FindBy(xpath = "    //*[@id=\"resource-upload\"]")
    public WebElement uploadButton;

    public void navigateToAdminPage(){
        webActions.clickOn(adminTab);
    }
    public void selectStaffRole(){
        Util.isWebElementVisible(this.driver, this.dropMenu);
    }

    public void selectUserRole(){
        Util.isWebElementVisible(this.driver, this.dropMenu);
    }

    public void clickOnEnable(){
        webActions.clickOn(enableButton);
    }
    public void userToBeEnabled(){
        Util.isWebElementVisible(this.driver, this.adminTab);
    }

    public void loginAsStaff(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        webActions.clickOn(this.logIn);
    }

    public void loginAsUser(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        webActions.clickOn(this.logIn);
    }

    public void loginAsAdmin(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        webActions.clickOn(this.logIn);
    }


    public void isOnIndex(){
        Util.verifyCurrentUrl("http://localhost:3000/");
    }
    public void clickOnResource(){
        webActions.clickOn(resourceTab);
    }

    public void adminTabNotDisplayed(){
        Util.isWebElementVisible(this.driver, this.logOut);
    }

    public void isUploadButtonDisplayed(){
        Util.isWebElementVisible(this.driver, this.uploadButton);
    }



}