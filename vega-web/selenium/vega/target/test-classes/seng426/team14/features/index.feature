Feature: Index Page
  Scenario: User should be able to view the public content on the index page
    Given I get to index page
    When I click on the first slide button
    Then I should see the first slide image