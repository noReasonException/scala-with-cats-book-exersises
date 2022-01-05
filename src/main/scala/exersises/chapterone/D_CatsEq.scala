package co.uk.noreasonexception
package exersises.chapterone

import cats.Show
import cats.kernel.Eq
import cats.syntax.show._
import cats.syntax.eq._
//Application
case class Cat3(name:String,age:Int,color:String)

object Cat3 {
  implicit def showForCats(
                            implicit strShow: Show[String],
                            intShow: Show[Int]): Show[Cat3] = new Show[Cat3] {
    override def show(obj: Cat3): String = {
      strShow.show(obj.name) + " is a " +
        intShow.show(obj.age) + " year-old " +
        strShow.show(obj.color) + " cat"
    }
  }
  implicit def eqForCats(implicit strEq:Eq[String],intEq:Eq[Int]):Eq[Cat3]={
    new Eq[Cat3] {
      override def eqv(x: Cat3, y: Cat3): Boolean =
        strEq.eqv(x.name,y.name)&&
          intEq.eqv(x.age,y.age)&&
          strEq.eqv(x.color,y.color)
    }
  }
}

object D_CatsEq{

  def main(args: Array[String]): Unit = {
    val zuko = Cat3("Zuko",1,"Black and white")
    val zukoAgain = Cat3("Zuko",1,"Black and white")
    val garfield = Cat3("Garfield",2,"Orange")
    print(zuko === garfield)
  }

}
