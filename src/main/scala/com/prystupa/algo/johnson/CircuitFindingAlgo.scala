package com.prystupa.algo.johnson

import collection.immutable.Stack
import com.prystupa.algo.tarjan.StronglyConnectedComponentsAlgo
import com.prystupa.algo.util.GraphUtils

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

//      val subAdjStructure = GraphUtils.subGraphOfOriginalSize(adjStructure, s)
//      val sccList = sccAlgo.compute(subAdjStructure).filterNot(_.size == 1)
//
//      if (!sccList.isEmpty) {
//        val sccWithLeastVertex = sccList.minBy(_.min)
//        s = sccWithLeastVertex.min
//
//
//
//        circuit(s)
//        s = s + 1
//      }
//      else {
//        s = n
//      }
    }

    ???
  }
}
