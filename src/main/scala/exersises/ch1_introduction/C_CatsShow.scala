package co.uk.noreasonexception
package exersises.ch1_introduction

import cats.Show
import cats.syntax.show._
import co.uk.noreasonexception.exersises.ch1_introduction.common.Cat

object CatInstancesC {
  implicit def ShowForCats(implicit
      strShow: Show[String],
      intShow: Show[Int]
  ): Show[Cat] = new Show[Cat] {
    override def show(any: Cat): String = {
      strShow.show(any.name) + " is a " +
        intShow.show(any.age) + " year-old " +
        strShow.show(any.color) + " cat"
    }

  }
}

object D_CatsShow {
  import CatInstancesC._
  def main(args: Array[String]): Unit = {
    val cat = Cat("Zuko", 1, "Black and white")
    print(cat.show)
  }

}
