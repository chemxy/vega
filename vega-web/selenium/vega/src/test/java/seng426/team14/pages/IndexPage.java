package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.webActions;

public class IndexPage extends Page {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage() {
        super();
    }

    @FindBy(id = "index-page-image-1")
    public WebElement slideImage1;

    @FindBy(id = "index-page-image-2")
    public WebElement slideImage2;

    @FindBy(id = "index-page-image-3")
    public WebElement slideImage3;

    @FindBy(xpath = "//buton[@aria-label='Slide 1']")
    public WebElement slideButton1;

    @FindBy(xpath = "//buton[@aria-label='Slide 2']")
    public WebElement slideButton2;

    @FindBy(xpath = "//buton[@aria-label='Slide 3']")
    public WebElement slideButton3;


   public void clickOnSlideButton1(){
       webActions.clickOn(this.slideButton1);
   }

    public void clickOnSlideButton2(){
        webActions.clickOn(this.slideButton2);
    }

    public void clickOnSlideButton3(){
        webActions.clickOn(this.slideButton3);
    }
}
