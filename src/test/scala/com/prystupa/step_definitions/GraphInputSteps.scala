package com.prystupa.step_definitions

import cucumber.api.java.en.Given

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 6:16 PM
 */

class GraphInputSteps(val world: World) extends World.Support {

  @Given("^the following edges of a graph with \"([^\"]*)\" vertices:$")
  def the_following_edges_of_a_graph_with_vertices(n: Int, edgeRows: java.util.List[EdgeRow]) {

    graph = parseGraph(n, edgeRows)
  }

}
