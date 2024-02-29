Feature: getModuleID

  Scenario: parent is root
    Given parentID = "1"
    And Parent has no Children
    When ChildCreated
    Then ChildID = "1,1"
Scenario: parent is not root
  Given parentID = "1,1"
  And Parent has no Children
  When ChildCreated
  Then ChildID = "1,1,1"

  Scenario: parent is not root and has a child
    Given parentID = "1,1"
    And Parent has 1 child
    When ChildCreated
    Then ChildID = "1,1,2"

    Scenario: parent is root and has a child
      Given parentID = "1"
      And Parent has 5 child
      When  ChildCreated
      Then ChildID = "1,6"

      Scenario: parent is root and has a child
        Given parentID = "1"
        And Parent has between 1 and 100 Children
        When ChildCreated
        Then ChildID = "1," Num Children

  Scenario: Module changes parent
    Given parentID = "1"
    And second parentID = "2"
    And  ChildCreated
    Then ChildID = "1,1"
    When Child Moves from one parent to another
    Then ChildID = "2,1"