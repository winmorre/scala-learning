package dsa

sealed trait BinaryTree[+A]

case object Leaf extends BinaryTree[Nothing]

case class Branch[A](value: A, left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]

object BinaryTreeApp {

  def createTree[A](list: List[A]): BinaryTree[A] = list match {
    case Nil => Leaf
    case x :: xs => {
      val halfLength = xs.length / 2
      Branch(x, createTree(xs.take(halfLength)), createTree(xs.drop(halfLength)))
    }
  }
}
