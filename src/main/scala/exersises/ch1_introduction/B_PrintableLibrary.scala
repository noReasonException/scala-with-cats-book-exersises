package co.uk.noreasonexception
package exersises.ch1_introduction

import exersises.ch1_introduction.common.{Cat, Printable}

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

object PrintableInstancesB {
  implicit val printableInstanceForInt = {
    new Printable[Int] {
      def format(any: Int): String = any.toString
    }
  }
  implicit val printableInstanceForStr = {
    new Printable[String] {
      def format(any: String): String = any
    }
  }
  implicit def printableInstanceForCat(implicit
      intPrintable: Printable[Int],
      strPrintable: Printable[String]
  ) = {
    new Printable[Cat] {
      override def format(any: Cat): String =
        strPrintable.format(any.name) + " is a " +
          intPrintable.format(any.age) + " year-old " +
          strPrintable.format(any.color) + " cat"
    }
  }

}
object Printable {
  implicit class PrintableOps[A](any: A) {
    def format(implicit printableInstance: Printable[A]) =
      printableInstance.format(any)
    def consolePrint(implicit printableInstance: Printable[A]) = print(format)
  }

}

object B_PrintableLibrary {
  import PrintableInstancesB._
  import Printable._
  def main(args: Array[String]): Unit = {
    val cat = Cat("Zuko", 1, "Black and white")
    print(cat.format)
  }

}
