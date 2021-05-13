package C_1_4

import cats.Show
import cats.Show._
import cats.syntax.show._
import cats.instances.int._
import cats.instances.string._

case class Cat(name:String,age:Int,color:String)
object Cat{
  implicit val catShowInstance:Show[Cat] = Show.show(cat=>cat.name+" is an "+cat.age+" year old "+cat.color+" cat")
}
object MainC14B {
  def main(args: Array[String]): Unit = {
    println(Cat("zuko",1,"black-white").show)
  }
}
