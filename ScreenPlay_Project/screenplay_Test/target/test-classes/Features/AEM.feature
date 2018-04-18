Feature: Searching google for a key word and confirming it exists

  Scenario: Google Search
    Given I navigate to google search page
    When I enter the key word AEM and enter
    Then I validate that the key word is on the list
    And I close the browser