package C_1_5

import cats.Eq
import cats.instances.option._
import cats.instances.int._
import cats.instances.string._
import cats.syntax.eq._
import cats.syntax.option._


case class Cat(name:String,age:Int,color:String)
object Cat{
  implicit val catEq=Eq.instance[Cat]{(a,b)=>a.name===b.name&&a.age===b.age&&a.color===b.color}
}
object FakeMainC15A {
  def main(args: Array[String]): Unit = {

    val a = Cat("zuko",1,"black-white")
    val b = Cat("zuko",1,"black-white")
    print(a===b)
  }
}
