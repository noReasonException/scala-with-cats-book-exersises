package co.uk.noreasonexception
package exersises.ch1_introduction

import cats.Show
import cats.kernel.Eq
import cats.syntax.show._
import cats.syntax.eq._
import co.uk.noreasonexception.exersises.ch1_introduction.common.Cat

object CatInstancesD {
  implicit def showForCats(implicit
      strShow: Show[String],
      intShow: Show[Int]
  ): Show[Cat] = new Show[Cat] {
    override def show(any: Cat): String = {
      strShow.show(any.name) + " is a " +
        intShow.show(any.age) + " year-old " +
        strShow.show(any.color) + " cat"
    }
  }
  implicit def eqForCats(implicit
      strEq: Eq[String],
      intEq: Eq[Int]
  ): Eq[Cat] = {
    new Eq[Cat] {
      override def eqv(first: Cat, second: Cat): Boolean =
        strEq.eqv(first.name, second.name) &&
          intEq.eqv(first.age, second.age) &&
          strEq.eqv(first.color, second.color)
    }
  }
}

object D_CatsEq {
  import CatInstancesD._
  def main(args: Array[String]): Unit = {
    val zuko = Cat("Zuko", 1, "Black and white")
    val zukoCopy = zuko.copy()
    val garfield = Cat("Garfield", 2, "Orange")
    print(zuko === zukoCopy)
  }

}
