package co.uk.noreasonexception
package exersises.ch1_introduction

import cats.Show
import cats.kernel.Eq
import cats.syntax.show._
import cats.syntax.eq._
//Application
case class Cat3(name: String, age: Int, color: String)

object Cat3 {
  implicit def showForCats(implicit
      strShow: Show[String],
      intShow: Show[Int]
  ): Show[Cat3] = new Show[Cat3] {
    override def show(any: Cat3): String = {
      strShow.show(any.name) + " is a " +
        intShow.show(any.age) + " year-old " +
        strShow.show(any.color) + " cat"
    }
  }
  implicit def eqForCats(implicit
      strEq: Eq[String],
      intEq: Eq[Int]
  ): Eq[Cat3] = {
    new Eq[Cat3] {
      override def eqv(first: Cat3, second: Cat3): Boolean =
        strEq.eqv(first.name, second.name) &&
          intEq.eqv(first.age, second.age) &&
          strEq.eqv(first.color, second.color)
    }
  }
}

object D_CatsEq {

  def main(args: Array[String]): Unit = {
    val zuko = Cat3("Zuko", 1, "Black and white")
    val zukoCopy = zuko.copy()
    val garfield = Cat3("Garfield", 2, "Orange")
    print(zuko === zukoCopy)
  }

}
