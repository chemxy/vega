package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadershipPage extends Page{

    public LeadershipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LeadershipPage() {
    }

    @FindBy(id = "leadership-image-Paul Aguilar")
    public WebElement leadershipImage1;


}
