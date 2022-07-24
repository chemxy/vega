Feature: Account Page
  Scenario: A user should be able to sign in with admin credentials
    Given I get to login page
    When I input correct Admin credentials
    And I click on login button
    Then Admin tab and logout tab are displayed

  Scenario: A user should not be able to sign in with wrong admin password
    Given I get to login page
    When I input incorrect Admin password
    And I click on login button
    Then Admin tab and logout tab are not displayed

  Scenario: A user should not be able to sign in with empty admin password
    Given I get to login page
    When I input empty Admin password
    And I click on login button
    Then Admin tab and logout tab are not displayed

  Scenario: A user should not be able to sign in with admin password and empty username
    Given I get to login page
    When I input Admin password and empty username
    And I click on login button
    Then Admin tab and logout tab are not displayed

  Scenario: A user should not be able to sign in with wrong credentials
    Given I get to login page
    When I input wrong credential
    And I click on login button
    Then logout tab is not displayed

  Scenario: A user should not be able to sign in with empty credentials
    Given I get to login page
    When I input empty credentials
    And I click on login button
    Then logout tab is not displayed

  Scenario: A user should be able to sign up account
    Given I get to login page
    When I click on sign up button
    And I input username first name last name and password
    And I click on signup1 button
    Then account is displayed as to be enabled in the Admin Tab

  Scenario: A user should be able to cancel sign up account
    Given I get to login page
    When I click on sign up button
    And I input username first name last name and password
    And I click on cancel signup button
    Then account is not displayed as to be enabled in the Admin Tab

  Scenario: A user signed in as admin should be able to log out
    Given I am logged in as admin
    When I get to logout page
    And I click on sign out button
    Then login tab is displayed

  Scenario: A user signed in as STAFF should be able to log out
    Given I am logged in as staff
    When I get to logout page
    And I click on sign out button
    Then login tab is displayed

  Scenario: A user signed in as USER should be able to log out
    Given I am logged in as user
    When I get to logout page
    And I click on sign out button
    Then login tab is displayed
