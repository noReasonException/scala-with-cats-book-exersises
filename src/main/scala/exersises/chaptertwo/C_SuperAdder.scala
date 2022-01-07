package co.uk.noreasonexception
package exersises.chaptertwo

import cats.syntax.semigroup._
import cats.{Monoid, Semigroup}

case class Order(totalCost:Double,quantity:Double)
object Order{
  private def combineOrder:(Order,Order)=>Order=(a,b)=>Order(a.totalCost+b.totalCost,a.quantity+b.quantity)
  implicit val semigroupOrder:cats.Semigroup[Order]=Semigroup.instance(combineOrder)
  implicit val monoidOrder:cats.Monoid[Order]=Monoid.instance(Order(0,0),combineOrder)
}
object Adder{
  def addV1(numbers:List[Int]):Int=numbers.foldLeft(0)(_ + _)
  def addV2[A](numbers:List[A])(implicit monoid: Monoid[A]):A=numbers.foldLeft(monoid.empty)(_ |+| _)

}

object C_SuperAdderV1 {
  import Adder._

  def main(args: Array[String]): Unit = {
    println(addV1(List(1,2,3,4)))
    println(addV2(List(Some(1),Some(2),Some(3),None,Some(4))))
    println(addV2(List(Order(1,2),Order(3,4))))
  }

}
