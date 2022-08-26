package dsa

object DecimalToBinaryConvApp {
  def main(args: Array[String])={
    println(decimalToBinaryConv(5))
    println(decimalToBinaryConv(8))
  }

  def decimalToBinaryConv(x:Int):String={
    val seqOfDivByTwo = Iterator.iterate(x) (a=>a/2)

    val binList = seqOfDivByTwo.takeWhile(a=>a>0)
      .map(a=>a%2)
    binList.mkString.reverse
  }
}
