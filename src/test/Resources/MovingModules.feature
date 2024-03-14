Feature: Moving Modules around

  Scenario: a window can be moved from ANY window to ANY window
    Given 1000 Random modules have been created
    When A random module is moved around randomly 1000 times whist being tracked
    Then The error rate is 0
    And All modules have been visited

    Scenario: Modules are moved using the mouse