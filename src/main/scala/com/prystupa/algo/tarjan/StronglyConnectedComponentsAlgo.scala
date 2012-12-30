package com.prystupa.algo.tarjan

import collection.immutable.Stack
import com.prystupa.algo.util.GraphUtils

/**
 * Created with IntelliJ IDEA.
 * User: eprystupa
 * Date: 12/28/12
 * Time: 6:09 PM
 */

class StronglyConnectedComponentsAlgo {

  type GraphAdjList = Vector[Set[Int]]
  type SubGraphAdjList = Map[Int, Set[Int]]

  def compute(adjacencyList: GraphAdjList): Vector[SubGraphAdjList] = {

    def strongConnect(v: Int, state: State): State = {

      if (!state.visited(v).isDefined) {
        // Consider successors of v
        adjacencyList(v).foldLeft(state.visit(v))((s, w) => {
          strongConnect(w, s).updateLowLink(v, w)
        }).collectScc(v)
      }
      else state
    }

    val n = adjacencyList.length
    val initialState = State(
      visited = Vector.fill(n)(None),
      next = 0,
      stack = Stack.empty,
      stacked = Vector.fill(n)(false),
      results = Vector.empty)

    (0 until n).foldLeft(initialState)((state, v) => strongConnect(v, state)).results.map(
      nodes => GraphUtils.subGraph(adjacencyList, nodes))
  }

  private case class Visited(index: Int, lowLink: Int)

  private case class State(visited: Vector[Option[Visited]],
                           next: Int,
                           stack: Stack[Int],
                           stacked: Vector[Boolean],
                           results: Vector[Set[Int]]) {

    def collectScc(v: Int): State = {
      def pop(r: Set[Int], s: Stack[Int]): (Set[Int], Stack[Int]) = {
        val (w, ss) = s.pop2
        if (w == v) (r + w, ss)
        else pop(r + w, ss)
      }

      // If v is a root node, pop the stack and generate an SCC
      visited(v).get match {
        case Visited(index, lowLink) if (index == lowLink) => {
          val (scc, remainingStack) = pop(Set.empty, stack)
          val stackedLessScc = scc.foldLeft(stacked)((s, w) => s updated(w, false))
          copy(stack = remainingStack, stacked = stackedLessScc, results = results :+ scc)
        }
        case _ => this
      }
    }

    def visit(i: Int) = copy(
      visited = visited updated(i, Some(Visited(next, next))),
      next = next + 1,
      stack = stack push (i),
      stacked = stacked updated(i, true)
    )

    def updateLowLink(v: Int, w: Int): State = (visited(v).get, visited(w).get) match {
      case (vv, ww) if (stacked(w) && ww.lowLink < vv.lowLink) => copy(visited = visited updated(v, Some(Visited(vv.index, ww.lowLink))))
      case _ => this
    }
  }

}
