Feature: finding a module at a gien XY Position
  Scenario: being able to find a module given an XY position
    Given the x coordinate of a new module as "0,0"
    When the coordinates "0,0" are given
    Then the created module should be returned
    And Want to do a commit cus i had a error i created and couldnt even revert back

