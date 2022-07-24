Feature: Admin Page
  Scenario: A user signed in as admin should be able to perform role change to STAFF
    Given I am logged in as admin
    And There is an account to be enabled
    When I navigate to the admin tab
    And I select STAFF from the dropdown menu of the account to be enabled
    And I click on Enable User
    Then I should be able to sign in as STAFF with the enabled account

  Scenario: A user signed in as admin should be able to perform role change to USER
    Given I am logged in as admin
    And There is an account to be enabled
    When I navigate to the admin tab
    And I select USER from the dropdown menu of the account to be enabled
    And I click on Enable User
    Then I should be able to sign in as USER with the enabled account

  Scenario:  A user signed in as staff should not be able to perform role change
    Given I am logged in as staff
    When I am on the index page
    Then The admin tab should not be displayed

  Scenario:  A user signed in as user should not be able to perform role change
    Given I am logged in as user
    When I am on the index page
    Then The admin tab should not be displayed
