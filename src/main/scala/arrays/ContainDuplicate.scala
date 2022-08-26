package arrays
import scala.util.control.Breaks._

object ContainDuplicate extends App {
  def solution(nums:Array[Int]):Boolean={
    var result:Boolean = false;
    breakable{
      for (n <- nums.sorted){
        val size = for(i<-nums if i == n) yield i
        if (size.length > 1){
          result = true
          break
        }
      }
    }
    result
  }

  val result = solution(nums = Array(1,2,3,1))
  println(result)
}
