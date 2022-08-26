package dsa

object PrimeNumbersApp {
  def main(args: Array[String]): Unit = {
    println(primes.take(15).toList)
  }

  def primes: LazyList[Int] = 2 #:: LazyList.from(3)
    .filter {
      x => {
        val sqrtOfPrimes = primes.takeWhile(y => y <= math.sqrt(x))
        !sqrtOfPrimes.exists(y => x % y == 0)
      }
    }
}
