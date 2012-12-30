package com.prystupa.step_definitions

import collection.JavaConversions._

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

    def parseGraph(n: Int, edgeRows: java.util.List[EdgeRow]) =
      Vector(0 until n: _*).map(i => edgeRows.filter(_.start - 1 == i).map(_.end - 1).toSet)

    case class EdgeRow(start: Int, end: Int)

  }

}