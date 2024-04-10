Feature: Search for an Book by name

  Scenario: Find an book by authors name
    Given the following books exist
     | BookId | Title   |  Author |
     |   *1   | Harry   |  Vlad   |
     |   *2   | Cat     |  Susan  |
    When Search the book by authors "Susan"
    Then Request returned code 200
    And Book will find
      | BookId | Title   |  Author |
      |   *2   | Cat     |  Susan  |
