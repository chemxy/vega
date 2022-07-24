Feature: Resource Page
  Scenario: A user signed in as admin should be able to see and access the resource page, as well as seeing the file selection menu and the submit button.
    Given I am logged in as admin
    When I click on resource tab
    Then I should see file selection menu
    And I should see submit button

  Scenario: A user signed in as STAFF should be able to see and access the resource page, but should not be able to see the file selection menu and the submit button.
    Given I am logged in as staff
    When I get to index page
    And I click on resource tab
    Then I should not see file selection menu
    And I should not see submit button

  Scenario: A user signed in as USER should not be able to see and access the resource page.
    Given I am logged in as user
    When I get to index page
    Then I should not see resource tab

