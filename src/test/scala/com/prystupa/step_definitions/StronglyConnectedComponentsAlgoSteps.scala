package com.prystupa.step_definitions

import collection.JavaConversions._
import org.scalatest.matchers.ShouldMatchers
import cucumber.api.java.en.{When, Then}
import com.prystupa.algo.tarjan.StronglyConnectedComponentsAlgo

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/28/12
 * Time: 8:19 PM
 */

class StronglyConnectedComponentsAlgoSteps(val world: World) extends World.Support with ShouldMatchers {

  val algo: StronglyConnectedComponentsAlgo = new StronglyConnectedComponentsAlgo
  var results: List[Set[Int]] = _


  @When("^I compute strongly connected components of this graph using Tarjan's algorithm$")
  def I_compute_strongly_connected_components_of_this_graph_using_Tarjan_s_algorithm() {

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

  case class NodeRow(node: Int)

}
