package com.prystupa.algo.util

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 5:38 PM
 */

object GraphUtils {

  def subGraphOfOriginalSize(adjStructure: Vector[Set[Int]], startNode: Int) = {

    val n = adjStructure.length
    val subGraph =
      (0 until startNode).map(_ => Set.empty[Int]) ++
        (startNode until n).map(adjStructure(_).filterNot(_ < startNode))
    subGraph.toVector
  }
}
