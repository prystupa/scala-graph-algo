package com.prystupa.algo.johnson

import collection.immutable.Stack
import com.prystupa.algo.tarjan.StronglyConnectedComponentsAlgo

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/29/12
 * Time: 4:20 PM
 */

class CircuitFindingAlgo {

  private val sccAlgo = new StronglyConnectedComponentsAlgo


  def compute(adjStructure: Vector[Set[Int]]): Vector[Vector[Int]] = {

    val n = adjStructure.length
    def subGraph(adjStructure: Vector[Set[Int]], startNode: Int): Vector[Set[Int]] = {

      val sub = (0 until startNode).map(_ => Set.empty[Int]) ++ (startNode until n).map(adjStructure(_).filterNot(_ < startNode))
      sub.toVector
    }

    var blocked = Vector.fill(n)(false)
    var stack: Stack[Int] = Stack()
    var s: Int = 0

    def circuit(v: Int) = {

      def unblock(u: Int) {
        blocked = blocked updated(u, false)


      }

      ???
    }

    while (s < n - 1) {

      val subAdjStructure = subGraph(adjStructure, s)

      val sccList = sccAlgo.compute(adjStructure.drop(s))

      if (!sccList.isEmpty) {

        circuit(s)
        s = s + 1
      }
      else {
        s = n
      }
    }

    ???
  }
}
