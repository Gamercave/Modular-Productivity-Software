Feature: finding a module at a given XY Position
  Scenario: being able to find a module given an XY position
    Given the x coordinate of a new module as 1 2
    When the coordinates "10,10" are given
    Then the created module should be returned

