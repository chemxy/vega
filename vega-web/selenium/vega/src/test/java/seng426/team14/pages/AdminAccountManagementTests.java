package seng426.team14.pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AdminAccountManagementTests {

    public WebDriver driver;

//    @Test
    public void adminLoginLogoutTest() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver-102.0.5005.61.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");   //access vega-web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));  //find element by xPath
        login.click();     //operation to do
        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/login", currURL);

        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));
        userName.sendKeys("admin@venus.com");
        passWord.sendKeys("pass");

        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/button"));
        submit.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a")).isDisplayed()); //logout button
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[7]")).isDisplayed()); //admin button

        WebElement logout = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));
        logout.click();
        WebElement signout = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/div/button"));
        signout.click();

        Assertions.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a")).getText(),"Login/SignUp"); //logout button
        Assertions.assertTrue(driver.findElements(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[7]")).isEmpty()); //admin button



        driver.quit();
    }


//    @Test
    public void adminLoginWrongCredTest() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver-102.0.5005.61.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");   //access vega-web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));  //find element by xPath
        login.click();     //operation to do
        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/login", currURL);

        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));
        userName.sendKeys("admin@venus.com");
        passWord.sendKeys("wrongpass");

        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/button"));
        submit.click();

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        //assertions unknown, tbd


        driver.quit();
    }

//    @Test
    public void adminLoginEmptyCredTest() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver-102.0.5005.61.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");   //access vega-web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));  //find element by xPath
        login.click();     //operation to do
        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/login", currURL);

        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));

        userName.sendKeys("");
        passWord.sendKeys(""); //both empty
        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/button"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
        //assertion tba
        userName.sendKeys("admin@venus.com");
        passWord.sendKeys(""); //password empty with correct username
        submit.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
        //assertion tba
        userName.sendKeys("");
        passWord.sendKeys("pass"); //password empty with correct password for some username
        submit.click();
        //assertion tba

        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);


        driver.quit();
    }

//    @Test
    public void roleChangeAvailableForAdminTest() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver-102.0.5005.61.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");   //access vega-web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));
        login.click();

        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));
        userName.sendKeys("admin@venus.com");
        passWord.sendKeys("pass");

        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/button"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement admin = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[7]"));
        admin.click();

        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/adminpanel", currURL);
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/table/thead/tr/td[1]")).isDisplayed()); //first name
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/table/thead/tr/td[2]")).isDisplayed()); //last name
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/table/thead/tr/td[3]")).isDisplayed()); //username

        driver.quit();
    }

//    @Test
    public void resourceUploadAvailableForAdminTest() {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver-102.0.5005.61.exe");

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("http://localhost:3000/");   //access vega-web
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement login = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/div/a"));
        login.click();

        WebElement userName = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[1]/input"));
        WebElement passWord = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/div[2]/input"));
        userName.sendKeys("admin@venus.com");
        passWord.sendKeys("pass");

        WebElement submit = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/form/button"));
        submit.click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);

        WebElement resource = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[1]/nav[2]/div/div/a[4]"));
        resource.click();

        String currURL = driver.getCurrentUrl();
        Assertions.assertEquals("http://localhost:3000/resources", currURL);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id=\"formFile\"]")).isDisplayed()); //path selector
        Assertions.assertTrue(driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[1]/div/button")).isDisplayed()); //submit

        //assertions for upload functioning tba



        driver.quit();
    }
}
