package co.uk.noreasonexception
package exersises.ch3_functors

import exersises.ch3_functors.common.Printable

object PrintableInstancesB {
  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def format(value: Int): String = value.toString
  }
  implicit val strPrintable: Printable[String] = new Printable[String] {
    override def format(value: String): String = value
  }

  implicit class PrintableOps[A](any: A) {
    def format(implicit printable: Printable[A]): String = printable.format(any)

  }

  def instance[A](implicit printable: Printable[A]): Printable[A] = printable
}

object B_ShowingOffWithContramap {
  import PrintableInstancesB._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
