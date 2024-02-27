Feature getModuleID

  Scenario: parent is root
    Given parentID = "1"
    And Parent has no Children
    When ChildCreated
    Then ChildID = "1,1"
