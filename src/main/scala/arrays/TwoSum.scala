package arrays

import java.util.Optional
import scala.util.control.Breaks._

object TwoSum extends App {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map :Map[Int,Int] = Map()
    val result:Array[Int]  = Array()
    for ((v,i) <- nums.zipWithIndex){
      val diff = target - v
      if (map.contains(diff)) {
        return Array(map(diff),i)
      }
      map+(v->i)
    }
    null
  }

  val k = twoSum(nums = Array(2,7,11,15),target = 9)
  println(k.mkString(" "))
}
