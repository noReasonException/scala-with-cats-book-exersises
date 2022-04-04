package co.uk.noreasonexception
package exersises.ch4_monads

import cats.Monad
import cats.implicits.toFlatMapOps
import cats.Id
import cats.implicits._
import scala.annotation.tailrec
//type class
//the monad instance
//extension methods
object I_CreatingCustomMonads{
  sealed trait Tree[+A]
  case class Branch[+A](left:Tree[A],right:Tree[A]) extends Tree[A]
  case class Leaf[+A](value:A) extends Tree[A]

  object Branch{
    def apply[A](left:Tree[A],right:Tree[A]):Tree[A]=new Branch(left,right)
  }
  object Leaf{
    def apply[A](value:A):Tree[A]=new Leaf(value)
  }

  implicit val treeMonad:Monad[Tree]=new Monad[Tree]{
    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] = fa match {
      case Branch(left, right) => Branch[B](flatMap(left)(f),flatMap(right)(f))
      case p@Leaf(value) => f(value)
    }


//    /**
//      * Thats the trivial non-stack-safe impl
//      */
//    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = {
//      flatMap(f(a)) {
//        case Left(value) => tailRecM(value)(f)
//        case Right(value) => Leaf(value)
//      }
//    }


    override def pure[A](x: A): Tree[A] = Leaf(x)
  }


  def main(args:Array[String]): Unit ={
    val leafR=Leaf(12)
    val leafL=Leaf(5)
    val branch:Tree[Int] = Branch(leafL,leafR)

    //val transformed = branch.iterateUntilM()
  }
}