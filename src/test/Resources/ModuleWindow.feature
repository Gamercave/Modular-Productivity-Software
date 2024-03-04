Feature: Modules have windows
  Scenario: Root Module is created and should have a window
    Given the user boots the application
    When the root module is created
    Then the module has a window positioned at x = 0 , y = 0

    Scenario: a second module is added
      Given A root module exists
      When the user adds a module to the root module
      Then the root module contains both the child module and window
      Scenario: a second module is removed from a different module
        Given A root module exists
        And A second module is added to the root module
        And A third module is added to the second module
        When the Third module is moved from the second module to the third module
      Then neither the third child nor its pane exist within the second module
        And the third module and its pane exist in the first module;

        Scenario: a window is created using UI designer
          Given  the UI designer contains a Button
          When  the UI is instantiated
          Then  the UI should contain a button


  Scenario:  a user can move a window themselves
    Given the root module is created
    When the user Moves a module
    Then Module location has changed