Feature: Rest API Functionalities

  Scenario: User able to add, get, and edit decoration
    Given A list of decorations are available
    When I add a decoration to the list
    Then The decoration is added
    When I get a specific decoration
    Then The specific decoration is available
    When I edit a decoration from the list
    Then the decoration content is edited
