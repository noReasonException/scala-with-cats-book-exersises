package co.uk.noreasonexception
package exersises.ch2_monoids_semigroups

import cats.syntax.semigroup._
import cats.{Monoid, Semigroup}
import co.uk.noreasonexception.exersises.ch2_monoids_semigroups.common.Order

object Adder {
  def addV1(numbers: List[Int]): Int = numbers.foldLeft(0)(_ + _)
  def addV2[A](listOfAny: List[A])(implicit monoid: Monoid[A]): A =
    listOfAny.foldLeft(monoid.empty)(_ |+| _)

}

object C_SuperAdderV1 {

  import Adder._

  def main(args: Array[String]): Unit = {
    println(addV1(List(1, 2, 3, 4)))
    println(addV2(List(Some(1), Some(2), Some(3), None, Some(4))))
    println(addV2(List(Order(1, 2), Order(3, 4))))
  }

}
