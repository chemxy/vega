Feature: News Page
  Scenario: User should be able to view the news on the news page if there is any
    Given I get to news page
    And There is a news post
    When I am on the news page
    Then I should see the post

  Scenario: User should be able to add a news post
    Given I get to news page
    And I am on the news page
    When I click on add news button
    And I input the news content
    And I click on submit news button
    Then I should see the corresponding news on the news page

  Scenario: User should be able to cancel a news post
    Given I get to news page
    And I am on the news page
    When I click on add news button
    And I input the news content
    And I click on cancel button
    Then I should not see the post


  Scenario: Admin user should be able to delete a news post
    Given I am logged in as admin
    And I navigate to news page
    And I am on the news page
    And there is a delete button
    When I click on delete button
    Then I should not see the post

    Scenario: Admin user should be able to edit a news post
      Given I am logged in as admin
      And I navigate to news page
      And I am on the news page
      And there is an edit button
      When I click on edit button
      And I input the news content
      And I click on submit news button
      Then I should see the corresponding news on the news page