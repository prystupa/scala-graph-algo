Feature: Various utility functions to manipulate graphs

  Scenario: Sub-graph of original size n starting from a given node
    Given the following edges of a graph with "3" vertices:
      | Start | End |
      | 1     | 2   |
      | 1     | 4   |
      | 2     | 3   |
      | 3     | 1   |
      | 3     | 5   |
    Then computed sub-graph starting with node "2" is:
      | Start | End |
      | 2     | 3   |
      | 3     | 5   |
