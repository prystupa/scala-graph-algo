package com.prystupa.step_definitions

import cucumber.api.java.en.Then
import com.prystupa.algo.util.GraphUtils
import org.scalatest.matchers.ShouldMatchers

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 6:56 PM
 */
class GraphUtilsSteps(val world: World) extends World.Support with ShouldMatchers {

  @Then("^computed sub-graph starting with node \"([^\"]*)\" is:$")
  def computed_sub_graph_starting_with_node_is(startNode: Int, edgeRows: java.util.List[EdgeRow]) {

    val expected = parseGraph(graph.length, edgeRows)
    val actual = GraphUtils.subGraphOfOriginalSize(graph, startNode - 1)
    actual should equal(expected)
  }
}
