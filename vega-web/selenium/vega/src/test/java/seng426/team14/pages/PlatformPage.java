package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seng426.team14.utils.Util;

public class PlatformPage extends Page{
    public PlatformPage(WebDriver driver) {
        super(driver);
    }

    public PlatformPage() {
        super();
    }

    @FindBy(xpath = "//*[@id=\"platform-container\"]")
    public WebElement platformContainer;

    @FindBy(id = "/html/body/div/div/div[1]/div[1]/nav[2]/div/div")
    public WebElement navbar;


    public void isContentDisplayed(){
        Util.isWebElementVisible(this.driver, this.platformContainer);
    }

}
