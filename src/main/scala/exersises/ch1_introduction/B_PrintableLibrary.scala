package co.uk.noreasonexception
package exersises.ch1_introduction

//Scala provides a toString method to let us convert any value to a String.
//However, this method comes with a few disadvantages: it is implemented for
//every type in the language, many implementations are of limited use, and we
//can’t opt‐in to specific implementations for specific types.
//Let’s define a Printable type class to work around these problems:
//  1. Define a type class Printable[A] containing a single method format.
//format should accept a value of type A and return a String.
//  2. Create an object PrintableInstances containing instances of
//Printable for String and Int.
//  3. Define an object Printable with two generic interface methods:
//format accepts a value of type A and a Printable of the correspond‐
//ing type. It uses the relevant Printable to convert the A to a String.
//print accepts the same parameters as format and returns Unit. It
//prints the formatted A value to the console using println.
trait Printable[A] {
  def format(obj: A): String
}
object PrintableInstances {
  implicit val printableInstanceForInt = {
    new Printable[Int] {
      def format(obj: Int): String = obj.toString
    }
  }
  implicit val printableInstanceForStr = {
    new Printable[String] {
      def format(obj: String): String = obj
    }
  }
  implicit def printableInstanceForCat(implicit
      intPrintable: Printable[Int],
      strPrintable: Printable[String]
  ) = {
    new Printable[Cat] {
      override def format(obj: Cat): String =
        strPrintable.format(obj.name) + " is a " +
          intPrintable.format(obj.age) + " year-old " +
          strPrintable.format(obj.color) + " cat"
    }
  }

}
object Printable {
  implicit class PrintableOps[A](obj: A) {
    def format(implicit printableInstance: Printable[A]) =
      printableInstance.format(obj)
    def consolePrint(implicit printableInstance: Printable[A]) = print(format)
  }

}
//Application
case class Cat(name: String, age: Int, color: String)

object B_PrintableLibrary {
  import PrintableInstances._
  import Printable._
  def main(args: Array[String]): Unit = {
    val cat = Cat("Zuko", 1, "Black and white")
    print(cat.format)
  }

}
