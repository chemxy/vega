package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class LeadershipPage extends Page{

    public LeadershipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LeadershipPage() {
    }

    @FindBy(xpath = "//*[@id=\"navbar-leadership-tab\"]")
    public WebElement leadershipTab;

    @FindBy(id = "leadership-image-Paul Aguilar")
    public WebElement leadershipImage1;

    @FindBy(id = "leadership-image-Jon Oliver")
    public WebElement leadershipImage2;

    @FindBy(id = "leadership-image-Claudine Zhang")
    public WebElement leadershipImage3;

    @FindBy(id = "leadership-image-Lovelin Kumar")
    public WebElement leadershipImage4;

    @FindBy(id = "leadership-image-Michel Kouame")
    public WebElement leadershipImage5;

    @FindBy(id = "leadership-image-Angelina Da Costa")
    public WebElement leadershipImage6;

    @FindBy(id = "leadership-image-Brijesh Gupta")
    public WebElement leadershipImage7;

    @FindBy(id = "leadership-image-Amy Fofana")
    public WebElement leadershipImage8;

    public void navigateToLeadershipPage(){
        webActions.clickOn(leadershipTab);
    }
    public void leadershipImagesDisplayed(){
        Util.isWebElementVisible(this.driver, this.leadershipImage1);
        Util.isWebElementVisible(this.driver, this.leadershipImage2);
        Util.isWebElementVisible(this.driver, this.leadershipImage3);
        Util.isWebElementVisible(this.driver, this.leadershipImage4);
        Util.isWebElementVisible(this.driver, this.leadershipImage5);
        Util.isWebElementVisible(this.driver, this.leadershipImage6);
        Util.isWebElementVisible(this.driver, this.leadershipImage7);
        Util.isWebElementVisible(this.driver, this.leadershipImage8);
    }

    public void isOnLeadershipPage(){
        Util.verifyCurrentUrl("http://localhost:3000/leadership");
    }

}
