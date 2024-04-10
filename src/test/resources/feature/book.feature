Feature: Search for an Auto by name

  Scenario: Find an book by its name
    Given the following books exist
      | Title     | Author |
      | Harry     | Vlad   |
      | Cat       | Susan  |
    When I search for the book named "Harry"
    Then I should find an author "Vlad"
