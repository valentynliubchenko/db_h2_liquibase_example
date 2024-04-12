Feature: Search for an Book by name

  Scenario: Create an book
    Given The books with title "Harry" and author "Vlad" does not exist
    When Create book with title "Harry" and author "Vlad"
    Then Request returned code 200
    And Book will be created
      | BookId | Title   |  Author |
      |   *1   | Harry   |  Vlad   |
