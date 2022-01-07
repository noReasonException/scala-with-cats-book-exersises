package C_3_5

import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import cats.syntax.monoid._

sealed trait Functor[F[_]] {
  def map[A, B](src: F[A])(fn: A => B): F[B]
}

object Functor {
  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](src: Tree[A])(fn: A => B): Tree[B] = src match {
      case b @ Branch(left, right) => Branch[B](map(left)(fn), map(right)(fn))
      case Leaf(value) => Leaf[B](fn(value))
    }
  }
}

sealed trait Tree[+A] {
  override def toString: String = this match {
    case b @ Branch(left, right) => left.toString + right.toString
    case Leaf(value) => value + "-"
  }
}

final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

object MainC35A {
  import Functor._
  def main(args: Array[String]): Unit = {
    /*val tree = Branch(Branch(Leaf(11),Leaf(2)),Leaf(200))
    val treeFn = Functor.treeFunctor
    val mapped=treeFn.map(tree)((a)=>a.toString+" mapped ")
    println(mapped)*/
  }
}
