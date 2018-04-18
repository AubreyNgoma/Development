Feature: Searching Wikipedia for a specific keyword and
         confirming it's the right page

  Scenario: Wikipedia Search
    Given I Navigate to the wikipedai home page
    When I search the term Behaviour Driven Developmnet and enter
    Then I should confirm it's the correct page
    And I close the wikipedai page and browser