package seng426.team14;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import seng426.team14.pages.*;
import seng426.team14.utils.DriverFactory;
import seng426.team14.utils.Util;
import seng426.team14.utils.webActions;

public class StepDefinitions {

    /* ------------------- declare properties ------------------*/
    protected WebDriver driver;
    protected IndexPage indexPage = new IndexPage();
    protected NewsAndEventsPage newsAndEventsPage = new NewsAndEventsPage();
    protected LeadershipPage leadershipPage = new LeadershipPage();
    protected PlatformPage platformPage = new PlatformPage();
    protected AccountSignInPage accountSignInPage = new AccountSignInPage();
    protected AdminPage adminPage = new AdminPage();

    protected ResourcePage resourcePage = new ResourcePage();

    protected ContactPage contactPage = new ContactPage();

    /* --------------------------- before and after lifecycles ------------------------------*/
    @Before // run before each scenario.
    public void setUp() throws Exception {
        System.out.println("DEBUG: before method: init driver");
        driver = DriverFactory.getInstance().getDriver();
        System.out.printf("DEBUG: Current Thread ID - %d\nThread Name - %s\nCurrent Driver - %s\n",
                Thread.currentThread().getId(), Thread.currentThread().getName(), driver.toString());
        //inject instance of page objects
        indexPage.setDriver(driver);
        leadershipPage.setDriver(driver);
        platformPage.setDriver(driver);
        newsAndEventsPage.setDriver(driver);
        accountSignInPage.setDriver(driver);
        adminPage.setDriver(driver);
        resourcePage.setDriver(driver);
        contactPage.setDriver(driver);

    }

    @After // run after each scenario, even when the step result is failed, undefined, pending, or skipped
    public void tearDown() throws Exception {
        System.out.println("DEBUG: after method: close driver");
        DriverFactory.getInstance().removeDriver();
    }

    /* --------------------------- step definitions ------------------------------*/
    @Given("I get to index page")
    public void iGetToIndexPage() {
        driver.get("http://localhost:3000/");
    }

    @When("I click on the first slide button")
    public void iClickOnTheFirstSlideButton() {
        indexPage.clickOnSlideButton1();
    }


    @Then("I should see the first slide image")
    public void iShouldSeeTheFirstSlideImage() {
        Util.isWebElementVisible(this.driver, this.indexPage.slideImage1);
    }


    @When("I click on platform tab")
    public void iClickOnPlatformTab() {
        driver.get("http://localhost:3000/platform");
    }


    @Then("I should see the navbar and the page content displayed")
    public void iShouldSeeTheNavbarAndThePageContentDisplayed() {
        platformPage.isContentDisplayed();
    }


    @Given("I get to news page")
    public void iGetToNewsPage() {
        driver.get("http://localhost:3000/news");
    }

    @When("I am on the news page")
    public void iAmOnTheNewsPage() {
        Util.verifyCurrentUrl("http://localhost:3000/news");
    }

    @And("There is a news post")
    public void thereIsANewsPost() {
        Util.isWebElementVisible(this.driver, this.newsAndEventsPage.newsContent1);
    }

    @Then("I should see the post")
    public void iShouldSeeThePost() {
        Util.isWebElementVisible(this.driver, this.newsAndEventsPage.newsContent1);
    }

    @When("I click on add news button")
    public void iClickOnAddNewsButton() {
        newsAndEventsPage.clickOnAddNewsButton();
    }

    @And("There is no news post on the page")
    public void thereIsNoNewsPostOnThePage() {
        newsAndEventsPage.deleteNewsPosts();
    }


    @And("I input the news content")
    public void iInputTheNewsContent() {
        newsAndEventsPage.inputNewsContent();
    }

    @Then("I should see the corresponding news on the news page")
    public void iShouldSeeTheCorrespondingNewsOnTheNewsPage() {
        newsAndEventsPage.verifyNewPost();
    }


    @And("I click on cancel button")
    public void iClickOnCancelButton() {
        newsAndEventsPage.clickOnCancel();
    }

    @Then("I should not see the post")
    public void iShouldNotSeeThePost() {
        newsAndEventsPage.verifyNoNewsPost();
    }


    @And("I am logged in as admin")
    public void iAmLoggedInAsAdmin() {
        newsAndEventsPage.loginAsAdmin();
        webActions.waitForLoad(this.driver);
    }


    @And("there is a delete button")
    public void thereIsADeleteButton() {
        newsAndEventsPage.isDeleteButtonDisplayed();
    }

    @When("I click on delete button")
    public void iClickOnDeleteButton() {
        newsAndEventsPage.clickOnDeleteButton();
    }


    @And("there is an edit button")
    public void thereIsAnEditButton() {
        newsAndEventsPage.isEditButtonDisplayed();
    }

    @When("I click on edit button")
    public void iClickOnEditButton() {
        newsAndEventsPage.clickOnEditButton();
    }

    @And("I navigate to news page")
    public void iNavigateToNewsPage() {
        newsAndEventsPage.clickOnNewsTab();
    }

    @And("I click on submit news button")
    public void iClickOnSubmitNewsButton() {
        newsAndEventsPage.clickOnSubmit();
    }

    @Given("I navigate to leadership page")
    public void iNavigateToLeadershipPage() {
        leadershipPage.navigateToLeadershipPage();
    }

    @When("I am on the leadership page")
    public void iAmOnTheLeadershipPage() {
        leadershipPage.isOnLeadershipPage();
    }


    @Then("All eight of the leadership images should be displayed")
    public void allEightOfTheLeadershipImagesShouldBeDisplayed() {
        leadershipPage.leadershipImagesDisplayed();
    }


    @And("There is an account to be enabled")
    public void thereIsAnAccountToBeEnabled() {
        adminPage.userToBeEnabled();
    }

    @When("I navigate to the admin tab")
    public void iNavigateToTheAdminTab() {
        adminPage.navigateToAdminPage();
    }

    @And("I select STAFF from the dropdown menu of the account to be enabled")
    public void iSelectSTAFFFromTheDropdownMenuOfTheAccountToBeEnabled() {
        adminPage.selectStaffRole();
    }

    @And("I click on Enable User")
    public void iClickOnEnableUser() {
        adminPage.clickOnEnable();
    }


    @Then("I should be able to sign in as STAFF with the enabled account")
    public void iShouldBeAbleToSignInAsSTAFFWithTheEnabledAccount() {
        adminPage.loginAsStaff();
        adminPage.adminTabNotDisplayed();
    }

    @Then("I should be able to sign in as USER with the enabled account")
    public void iShouldBeAbleToSignInAsUSERWithTheEnabledAccount() {
        adminPage.loginAsUser();
        adminPage.adminTabNotDisplayed();
    }

    @And("I select USER from the dropdown menu of the account to be enabled")
    public void iSelectUSERFromTheDropdownMenuOfTheAccountToBeEnabled() {
        adminPage.selectUserRole();
    }


    @When("I am on the index page")
    public void iAmOnTheIndexPage() {
        adminPage.isOnIndex();
    }

    @Then("The admin tab should not be displayed")
    public void theAdminTabShouldNotBeDisplayed() {
        adminPage.adminTabNotDisplayed();
    }

    @Given("I am logged in as user")
    public void iAmLoggedInAsUser() {
        adminPage.loginAsUser();
    }

    @Given("I am logged in as staff")
    public void iAmLoggedInAsStaff() {
        adminPage.loginAsStaff();
    }

    @And("I click on resource tab")
    public void iClickOnResourceTab() {
        resourcePage.clickOnResouceTab();
    }

    @Then("I should see file selection menu")
    public void iShouldSeeFileSelectionMenu() {
        resourcePage.isFileSelectionDisplayed();
    }

    @And("I should see submit button")
    public void iShouldSeeSubmitButton() {
        resourcePage.isSubmitDisplayed();
    }

    @Then("I should not see file selection menu")
    public void iShouldNotSeeFileSelectionMenu() {
        resourcePage.fileSelectionDisabled();
    }

    @And("I should not see submit button")
    public void iShouldNotSeeSubmitButton() {
        resourcePage.fileSelectionDisabled();
    }

    @Then("I should not see resource tab")
    public void iShouldNotSeeResourceTab() {
        resourcePage.resourceTabDisabled();
    }


    @When("I click on contact us tab")
    public void iClickOnContactUsTab() {
        contactPage.clickOnContactTab();

    }

    @Then("I should see the name, email, and message text boxes, as well as the submit button")
    public void iShouldSeeTheNameEmailAndMessageTextBoxesAsWellAsTheSubmitButton() {
        contactPage.areFieldsDisplayed();
    }


    @Then("I should be able to send text to the text boxes")
    public void iShouldBeAbleToSendTextToTheTextBoxes() {
        contactPage.sendText();
    }

    @And("I should be able to click on Submit button")
    public void iShouldBeAbleToClickOnSubmitButton() {
        contactPage.sendText();
        contactPage.clickOnSubmit();
    }


    @Given("I am not logged in")
    public void iAmNotLoggedIn() {
        accountSignInPage.isNotLoggedIn();
    }

    @When("I get to login page")
    public void iGetToLoginPage() {
        accountSignInPage.directToLocginPage();
    }

    @And("I input correct Admin credentials")
    public void iInputCorrectAdminCredentials() {
        accountSignInPage.loginAsAdmin();
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {

    }

    @Then("Admin tab and logout tab are displayed")
    public void adminTabAndLogoutTabAreDisplayed() {
        accountSignInPage.isAdminTabDisplayed();
    }

    @And("I input incorrect Admin password")
    public void iInputIncorrectAdminPassword() {
        accountSignInPage.loginAsWrongAdminPass();
    }

    @Then("Admin tab and logout tab are not displayed")
    public void adminTabAndLogoutTabAreNotDisplayed() {
        accountSignInPage.adminTabNotDisplayed();
    }

    @And("I input empty Admin password")
    public void iInputEmptyAdminPassword() {
        accountSignInPage.loginAsEmptyAdminPass();
    }

    @And("I input Admin password and empty username")
    public void iInputAdminPasswordAndEmptyUsername() {
        accountSignInPage.loginAsEmptyAdminUsername();
    }

    @And("I input wrong credential")
    public void iInputWrongCredential() {
        accountSignInPage.loginAsWrongCred();
    }

    @Then("logout tab is not displayed")
    public void logoutTabIsNotDisplayed() {

    }

    @And("I input empty credentials")
    public void iInputEmptyCredentials() {
        accountSignInPage.loginAsWrongCred();
    }

    @And("I click on sign up button")
    public void iClickOnSignUpButton() {
        accountSignInPage.clickOnSignup();

    }

    @And("I input username first name last name and password")
    public void iInputUsernameFirstNameLastNameAndPassword() {
        accountSignInPage.signUpAccount();
    }

    @And("I click on signup1 button")
    public void iClickOnSignupButton1() {
        accountSignInPage.clickOnSignUpSubmit();
    }

    @Then("account is displayed as to be enabled in the Admin Tab")
    public void accountIsDisplayedAsToBeEnabledInTheAdminTab() {
        adminPage.loginAsAdmin();
        adminPage.navigateToAdminPage();
        adminPage.userToBeEnabled();
    }

    @And("I click on cancel signup button")
    public void iClickOnCancelSignupButton() {
        accountSignInPage.clickOnSignUpCancel();
    }

    @Then("account is not displayed as to be enabled in the Admin Tab")
    public void accountIsNotDisplayedAsToBeEnabledInTheAdminTab() {
        adminPage.loginAsAdmin();
        adminPage.navigateToAdminPage();
        adminPage.userToBeEnabled();
    }

    @When("I get to logout page")
    public void iGetToLogoutPage() {
        accountSignInPage.navigateToLogout();
    }

    @And("I click on sign out button")
    public void iClickOnSignOutButton() {
        accountSignInPage.logout();
    }

    @And("login tab is displayed")
    public void loginTabIsDisplayed() {
        accountSignInPage.loginTabDisplayed();
    }

    @And("Admin tab and resource tab are no longer displayed")
    public void adminTabAndResourceTabAreNoLongerDisplayed() {

    }

    @And("resource tab is no longer displayed")
    public void resourceTabIsNoLongerDisplayed() {
    }

    @Given("I get to sign up page")
    public void iGetToSignUpPage() {
        driver.get("http://localhost:3000/signup");
    }
}

