package co.uk.noreasonexception
package exersises.ch3_functors

import exersises.ch3_functors.common.Printable

import co.uk.noreasonexception.common.Box

object PrintableInstancesC {
  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
  implicit def boxPrintable[A](implicit
      innerPrintable: Printable[A]
  ): Printable[Box[A]] = innerPrintable.contraMap[Box[A]](_.value)

  implicit class PrintableOps2[A](value: A) {
    def format(implicit printable: Printable[A]): String =
      printable.format(value)

  }

  def instance[A](implicit printable: Printable[A]): Printable[A] = printable
}

object C_ShowingOffWithContramapPt2 {
  import PrintableInstancesC._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
