package com.prystupa.algo.util

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 5:38 PM
 */

object GraphUtils {

  type GraphAdjList = Vector[Set[Int]]
  type SubGraphAdjList = Map[Int, Set[Int]]


  def subGraphOfOriginalSize(adjStructure: GraphAdjList, startNode: Int): GraphAdjList = {

    val n = adjStructure.length
    val subGraph =
      (0 until startNode).map(_ => Set.empty[Int]) ++
        (startNode until n).map(adjStructure(_).filterNot(_ < startNode))
    subGraph.toVector
  }

  def subGraph(original: GraphAdjList, nodes: Set[Int]): SubGraphAdjList = {

    nodes.map(i => (i, original(i) intersect (nodes))).toMap
  }
}
