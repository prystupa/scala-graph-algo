package com.prystupa.step_definitions

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 6:14 PM
 */

class World {
  private var _graph: Vector[Set[Int]] = _

}

object World {

  trait Support {
    val world: World

    def graph = world._graph

    def graph_=(value: Vector[Set[Int]]) {
      world._graph = value
    }
  }

}