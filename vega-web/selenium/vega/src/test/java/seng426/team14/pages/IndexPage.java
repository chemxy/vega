package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Page {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage() {
        super();
    }

    @FindBy(id = "sampleElement")
    public WebElement sampleElement;
}
