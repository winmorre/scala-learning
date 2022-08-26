package graphs

import scala.collection.mutable

object UndirectedGraphComponent {
  def main(args: Array[String]): Unit = {
    val graph = mutable.Map.empty[String,Array[String]]
    graph += ("0"->Array("8","1","5"))
    graph += ("1"->Array("0"))
    graph += ("5"->Array("0","8"))
    graph += ("8"->Array("0","5"))
    graph += ("2"->Array("3","4"))
    graph += ("3"->Array("2","4"))
    graph += ("4"->Array("3","2"))

    val result = canConnect(graph = graph)
    println(result)
  }

  def explore(graph: mutable.Map[String, Array[String]], node: String, visited: mutable.Set[String]): Boolean = {
    if (!visited.add(node)) return false

    for (n <- graph(node)) {
      explore(graph = graph, node = n, visited = visited)
    }
    true
  }

  def canConnect(graph: mutable.Map[String, Array[String]]): Int = {
    var count = 0;
    val visited = mutable.Set.empty[String]
    for (node <- graph.keys) {
      if (explore(graph = graph, node = node, visited = visited)) {
        count += 1
      }
    }
    count
  }
}
