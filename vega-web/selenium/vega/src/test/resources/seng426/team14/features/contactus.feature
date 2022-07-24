Feature: Contact Us Page
  Scenario: A user should be able to see and access the contact us tab
    Given I get to index page
    When I click on contact us tab
    Then I should see the name, email, and message text boxes, as well as the submit button

  Scenario: A user should be able to interact with the menu
    Given I get to index page
    When I click on contact us tab
    Then I should be able to send text to the text boxes
    And I should be able to click on Submit button