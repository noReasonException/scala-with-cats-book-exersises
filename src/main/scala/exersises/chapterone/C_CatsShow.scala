package co.uk.noreasonexception
package exersises.chapterone

import cats.Show
import cats.syntax.show._

//Application
case class Cat2(name: String, age: Int, color: String)

object Cat2 {
  implicit def ShowForCats(implicit
      strShow: Show[String],
      intShow: Show[Int]
  ): Show[Cat2] = new Show[Cat2] {
    override def show(obj: Cat2): String = {
      strShow.show(obj.name) + " is a " +
        intShow.show(obj.age) + " year-old " +
        strShow.show(obj.color) + " cat"
    }

  }
}

object D_CatsShow {

  def main(args: Array[String]): Unit = {
    val cat = Cat2("Zuko", 1, "Black and white")
    print(cat.show)
  }

}
