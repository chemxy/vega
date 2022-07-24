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

    @FindBy(xpath = "//*[@id=\"login-signup-button\"]")
    public WebElement signUpButton;

    @FindBy(xpath = "/html/body/div/form/div[1]/div/textarea")
    public WebElement signUpUserName;

    @FindBy(xpath = "/html/body/div/form/div[2]/div/textarea")
    public WebElement signUpFirstName;

    @FindBy(xpath = "/html/body/div/form/div[3]/div/textarea")
    public WebElement signUpLastName;

    @FindBy(xpath = "/html/body/div/form/div[4]/div/textarea")
    public WebElement signUpPass;

    @FindBy(xpath = "/html/body/div/form/button[1]")
    public WebElement signUpSubmit;

    @FindBy(xpath = "/html/body/div/form/button[2]")
    public WebElement signUpCancel;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a")
    public WebElement logoutTab;

    @FindBy(xpath = "//*[@id=\"account-signout-button\"]")
    public WebElement signOutButton;


    public void isAdminTabDisplayed(){
        Util.isWebElementVisible(this.driver, adminTab);
    }

    public  void clickOnSubmit(){
        webActions.clickOn(submit);
    }

    @FindBy(xpath = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a")
    public WebElement loginTab;


    public void loginAsAdmin(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        this.clickOnSubmit();
    }

    public void isNotLoggedIn(){
        Util.isWebElementVisible(this.driver, this.loginTab);
    }

    public void directToLocginPage(){
        driver.get("http://localhost:3000/login");
    }

    public void loginAsWrongAdminPass(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "wrong");
        this.clickOnSubmit();
    }

    public void loginAsEmptyAdminPass(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "");
        this.clickOnSubmit();
    }

    public void loginAsEmptyAdminUsername(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "");
        webActions.setText(password, "pass");
        this.clickOnSubmit();
    }

    public void loginAsWrongCred(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "testwrong");
        webActions.setText(password, "testwrong");
        this.clickOnSubmit();
    }

    public void loginAsEmptyCred(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "");
        webActions.setText(password, "");
        this.clickOnSubmit();
    }

    public void adminTabNotDisplayed(){

    }

    public void clickOnSignup(){
        webActions.clickOn(signUpButton);
        Util.verifyCurrentUrl("http://localhost:3000/signup");
    }
    public void signUpAccount(){
        webActions.setText(signUpUserName, "testSignupUser");
        webActions.setText(signUpFirstName, "testSignupFN");
        webActions.setText(signUpLastName, "testSunupLN");
        webActions.setText(signUpPass, "signuptest");
       // webActions.clickOn(signUpSubmit);
    }

    public void cancelSignUpAccount(){

        webActions.setText(signUpUserName, "testSignupUser");
        webActions.setText(signUpFirstName, "testSignupFN");
        webActions.setText(signUpLastName, "testSunupLN");
        webActions.setText(signUpPass, "signuptest");
     //   webActions.clickOn(signUpCancel);
    }

    public void clickOnSignUpCancel(){
        webActions.clickOn(signUpCancel);
    }

    public void clickOnSignUpSubmit(){
        webActions.clickOn(signUpSubmit);
    }

    public void navigateToLogout(){
        driver.get("http://localhost:3000/account");
    }

    public void loginAsStaff(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "jonoliver@venus.com");
        webActions.setText(password, "pass");
        this.clickOnSubmit();
    }

    public void loginAsUser(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "jonoliver@venus.com");
        webActions.setText(password, "pass");
        this.clickOnSubmit();
    }

    public void logout(){
        //webActions.clickOn(logoutTab);
        webActions.clickOn(signOutButton);
    }

    public void loginTabDisplayed(){
        Util.isWebElementVisible(this.driver, this. loginTab);
    }

}
