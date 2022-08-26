import scala.collection.mutable

object Main {
  def main(args: Array[String]): Unit = {
    val wordBank = Array("purp", "p", "ur", "le", "purpl")
    val wordBankBig = Array("e", "ee", "eee", "eeee", "eeeee", "eeeeee")
    val m = allConstruct(target = "purple", wordBank = wordBank, memo = mutable.HashMap.empty).mkString("Array(", ", ", ")")
    println(m.toString)

    println(allConstruct(target = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", wordBank = wordBankBig, memo = mutable.HashMap.empty).mkString("Array(", ", ", ")").mkString)
  }

  def countConstruct(target: String, wordBank: Array[String], memo: mutable.Map[String, Int]): Int = {
    if (memo.contains(target)) return memo(target);
    if (target.isEmpty) return 1;
    var count = 0
    for (word <- wordBank) {
      if (target.indexOf(word) == 0) {
        val numberOfWays = countConstruct(target.slice(word.length, target.length), wordBank, memo)
        count += numberOfWays
      }
    }
    memo += (target -> count)
    count
  }

  def allConstruct(target: String, wordBank: Array[String], memo: mutable.HashMap[String, Array[Array[String]]]): Array[Array[String]] = {
    if (memo.contains(target)) return memo(target)
    if (target.isEmpty) return Array(Array.empty[String])
    val result = Array(Array.empty[String])
    for (word <- wordBank) {
      if (target.indexOf(word) == 0) {
        val suffix = target.slice(word.length, target.length)
        val way = allConstruct(target = suffix, wordBank = wordBank, memo = memo)
        val targetWays: Array[Array[String]] = way.map(m => Array(word) ++ m)
        result ++ targetWays
      }
    }
    memo += (target -> result)
    result
  }
}
