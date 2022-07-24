package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class NewsAndEventsPage extends Page{

    public NewsAndEventsPage(WebDriver driver) {
        super(driver);
    }

    public NewsAndEventsPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"login-username-input\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"login-submit-button\"]")
    public WebElement logIn;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[2]/button")
    public WebElement addNewsButton;

    @FindBy(id = "news-edit-button-0")
    public WebElement editNewsButton;

    @FindBy(id = "news-delete-button-0")
    public WebElement deleteNewsButton;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div/h1")
    public WebElement newsTitle1;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div/h2")
    public WebElement newsSubtitle1;

    @FindBy(xpath = "/html/body/div/div/div[1]/div[3]/div[1]")
    public WebElement newsContent1;

    @FindBy(xpath = "/html/body/div/div/form/div[1]/div/textarea")
    public WebElement titleTextBox;

    @FindBy(xpath = "/html/body/div/div/form/div[2]/div/textarea")
    public WebElement subTitleTextBox;

    @FindBy(xpath = "/html/body/div/div/form/div[3]/div/textarea")
    public WebElement contentTextBox;

    @FindBy(xpath = "/html/body/div/div/form/button[1]")
    public WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div/form/button[2]")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@id=\"navbar-news-tab\"]")
    public WebElement newsTabOnNav;

    public void clickOnNewsTab(){
        webActions.clickOn(newsTabOnNav);
    }

    public void clickOnAddNewsButton(){
        webActions.clickOn(this.addNewsButton);

    }
    public void clickOnEditButton(){
        webActions.clickOn(this.editNewsButton);
    }
    public void clickOnDeleteButton(){
        webActions.clickOn(this.deleteNewsButton);
    }
    public void clickOnSubmit(){
        webActions.clickOn(this.submitButton);
    }

    public void clickOnCancel(){
        webActions.clickOn(this.cancelButton);
    }

    public void inputNewsContent(){
        webActions.setText(this.titleTextBox,"test title");
        webActions.setText(this.subTitleTextBox, "test subtitle");
        webActions.setText(this.contentTextBox, "test content");
    }

    public boolean verifyNoNewsPost(){
        return !Util.isWebElementVisible(this.driver, this.newsTitle1);
    }

    public void deleteNewsPosts(){
        while(Util.isWebElementVisible(this.driver, this.newsTitle1)) {
            clickOnDeleteButton();
        }
    }

    public void isDeleteButtonDisplayed(){
        Util.isWebElementVisible(this.driver, deleteNewsButton);
    }


    public void verifyNewPost(){
        Util.isWebElementVisible(this.driver, newsTitle1);
        Util.isWebElementVisible(this.driver, newsSubtitle1);
        Util.isWebElementVisible(this.driver, newsContent1);
    }

    public void isEditButtonDisplayed(){
        Util.isWebElementVisible(this.driver, this.editNewsButton);
    }

    public void loginAsAdmin(){
        driver.get("http://localhost:3000/login");
        webActions.setText(username, "admin@venus.com");
        webActions.setText(password, "pass");
        webActions.clickOn(this.logIn);
    }




}
