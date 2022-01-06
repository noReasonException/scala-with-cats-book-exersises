package co.uk.noreasonexception
package exersises.chaptertwo

import exersises.chaptertwo.common.Monoid

//object MonoidUnion{
//  implicit def unionMonoid[A](implicit monoid: Monoid[A]):Monoid[Set[A]]=new Monoid[Set[A]] {
//    override def empty: Set[A] = Set(monoid.empty)
//    override def combine(first: Set[A], second: Set[A]): Set[A] = ???
//  }
//}

object B_TruthAboutSets {
  import Monoid._
  import MonoidAnd._

  def main(args: Array[String]): Unit = {
    print(true.combine(false).combine(empty))
  }

}
