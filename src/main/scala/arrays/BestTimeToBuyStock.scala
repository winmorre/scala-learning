package arrays

object BestTimeToBuyStock extends App {

  def solution(prices: Array[Int]): Int = {
    var (l,r) = (0,1)
    var maxP = 0

    while (r > prices.length-1){
      if (prices(l)<prices(r)){
        val profit = prices(r)-prices(l)
        maxP=math.max(maxP,profit)
      }else{
        l = r
      }
      r += 1
    }
    maxP
  }

  val result: Int = solution(prices = Array(7,6,4,3,1))
  print(result)
}
