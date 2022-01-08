package co.uk.noreasonexception
package exersises.ch1_introduction

import cats.Show
import cats.syntax.show._

//Application
case class Cat2(name: String, age: Int, color: String)

object Cat2 {
  implicit def ShowForCats(implicit
      strShow: Show[String],
      intShow: Show[Int]
  ): Show[Cat2] = new Show[Cat2] {
    override def show(any: Cat2): String = {
      strShow.show(any.name) + " is a " +
        intShow.show(any.age) + " year-old " +
        strShow.show(any.color) + " cat"
    }

  }
}

object D_CatsShow {

  def main(args: Array[String]): Unit = {
    val cat = Cat2("Zuko", 1, "Black and white")
    print(cat.show)
  }

}
