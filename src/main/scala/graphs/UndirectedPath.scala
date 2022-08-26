package graphs

import scala.collection.mutable
import scala.collection.mutable.*

object UndirectedPath {
  /* For undirected graph u need to first convert the edges given into graphs
   then you can use breadth first or depth search to traverse the graphs
    For depth first, you can use recursive function or a stack
   for BFS u can use Queue
    for
  */
  def main(args: Array[String]): Unit = {
    val edges:Array[Array[String]] = Array(Array("i","j"),Array("k","i"),Array("m", "k"), Array("k", "l"), Array("o", "n"))
    val s1 = solution(edges = edges, src = "j", dst="m")
    println(s1)
  }


  def buildGraph(edges: Array[Array[String]]): mutable.Map[String, Array[String]] = {
    val graph = mutable.Map.empty[String, Array[String]]
    for (e: Array[String] <- edges) {
      val (a: String, b: String) = (e(0), e(1))
      if (!graph.contains(a)) graph += (a -> Array.empty[String])
      if (!graph.contains(b)) graph += (b -> Array.empty[String])

      val aList = graph(a) :+ b
      graph.update(a, aList)

      val bList = graph(b) :+ a
      graph.update(b, bList)
    }
    graph
  }

  def hasPath(graph: mutable.Map[String, Array[String]], src: String, dst: String, visited: mutable.Set[String]): Boolean = {
    if (src == dst) return true
    if (visited.contains(src)) return false
    visited.add(src)
    for (neighbor <- graph(src)) {
      if (hasPath(graph, neighbor, dst, visited)) return true
    }
    false
  }

  def solution(edges: Array[Array[String]], src: String, dst: String): Boolean = {
    val graph = buildGraph(edges)
    hasPath(graph = graph, src = src, dst = dst, visited = mutable.Set.empty[String])
  }

}
