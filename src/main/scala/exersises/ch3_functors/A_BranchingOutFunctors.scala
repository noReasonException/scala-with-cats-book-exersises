package co.uk.noreasonexception
package exersises.ch3_functors

import cats.Functor
import cats.implicits._
import cats.syntax.functor
sealed trait Tree[+A]

case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A]

case class Leaf[+A](value: A) extends Tree[A]

object Tree {
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](tree: Tree[A])(f: A => B): Tree[B] = tree match {
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
      case Leaf(value) => Leaf(f(value))
    }
  }
}

object A_BranchingOutFunctors {
  import Tree._
  def main(args: Array[String]): Unit = {
    val intTree: Tree[Int] = Branch(Leaf(12), Branch(Leaf(12), Leaf(12)))
    println(intTree.map(_.toString + "!"))
  }
}
