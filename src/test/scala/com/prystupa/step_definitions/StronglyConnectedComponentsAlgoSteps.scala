package com.prystupa.step_definitions

import collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers
import cucumber.api.java.en.{Then, Given}
import com.prystupa.algo.tarjan.StronglyConnectedComponentsAlgo

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/28/12
 * Time: 8:19 PM
 */

class StronglyConnectedComponentsAlgoSteps extends ShouldMatchers {

  val algo: StronglyConnectedComponentsAlgo = new StronglyConnectedComponentsAlgo
  var graph: Vector[Set[Int]] = _
  var results: List[Set[Int]] = _

  @Given("^the following edges of a graph with \"([^\"]*)\" vertices:$")
  def the_following_edges_of_a_graph_with_vertices(n: Int, edgeRows: java.util.List[EdgeRow]) {

    graph = Vector(0 until n: _*).map(i => edgeRows.filter(_.start - 1 == i).map(_.end - 1).toSet)
    results = algo.compute(graph).toList
  }

  @Then("^there is a connected component of the graph:$")
  def there_is_a_connected_component_of_the_graph(nodes: java.util.List[NodeRow]) {

    results = results match {
      case head :: tail => {
        head.map(_ + 1) should equal(nodes.map(_.node).toSet)
        tail
      }
      case Nil => throw new IllegalStateException("Too few results")
    }
  }

  @Then("^no other connected components$")
  def no_other_connected_components() {
    results should equal(Nil)
  }

  case class EdgeRow(start: Int, end: Int)

  case class NodeRow(node: Int)

}
