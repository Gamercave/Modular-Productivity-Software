Feature: Modules have windows
  Scenario: Root Module is created and should have a window
    Given the user boots the aplication
    When the root module is created
    Then the module has a window positioned at x = 0 , y = 0