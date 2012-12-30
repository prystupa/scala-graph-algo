Feature: Computing strongly connected components of a graph using Tarjan's algorithm

  Scenario: Simple chain with no loops
    Given the following edges of a graph with "3" vertices:
      | Start | End |
      | 1     | 2   |
      | 2     | 3   |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 3    |            |
    And there is a connected component of the graph:
      | Node | Successors |
      | 2    |            |
    And there is a connected component of the graph:
      | Node | Successors |
      | 1    |            |
    And no other connected components

  Scenario: Simple set of disconnected nodes
    Given the following edges of a graph with "3" vertices:
      | Start | End |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 1    |            |
    And there is a connected component of the graph:
      | Node | Successors |
      | 2    |            |
    And there is a connected component of the graph:
      | Node | Successors |
      | 3    |            |
    And no other connected components

  Scenario: Simple two nodes loop
    Given the following edges of a graph with "2" vertices:
      | Start | End |
      | 1     | 2   |
      | 2     | 1   |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 1    | 2          |
      | 2    | 1          |
    And no other connected components

  Scenario: Simple three node loop
    Given the following edges of a graph with "3" vertices:
      | Start | End |
      | 1     | 2   |
      | 2     | 3   |
      | 3     | 1   |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 1    | 2          |
      | 2    | 3          |
      | 3    | 1          |
    And no other connected components

  Scenario: Graph with two loops (first loop has a path to second)
    Given the following edges of a graph with "5" vertices:
      | Start | End |
      | 1     | 2   |
      | 2     | 3   |
      | 3     | 1   |
      | 3     | 4   |
      | 4     | 5   |
      | 5     | 4   |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 4    | 5          |
      | 5    | 4          |
    And there is a connected component of the graph:
      | Node | Successors |
      | 1    | 2          |
      | 2    | 3          |
      | 3    | 1          |

  Scenario: Graph with two loops (second loop has a path to first)
    Given the following edges of a graph with "5" vertices:
      | Start | End |
      | 1     | 4   |
      | 2     | 3   |
      | 3     | 2   |
      | 3     | 4   |
      | 4     | 5   |
      | 5     | 1   |
    When I compute strongly connected components of this graph using Tarjan's algorithm
    Then there is a connected component of the graph:
      | Node | Successors |
      | 1    | 4          |
      | 4    | 5          |
      | 5    | 1          |
    Then there is a connected component of the graph:
      | Node | Successors |
      | 2    | 3          |
      | 3    | 2          |
