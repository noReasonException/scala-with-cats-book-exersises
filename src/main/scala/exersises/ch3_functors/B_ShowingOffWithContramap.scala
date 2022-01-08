package co.uk.noreasonexception
package exersises.ch3_functors

trait Printable[A] {
  self =>
  def format(value: A): String
  def contraMap[B](f: B => A): Printable[B] = new Printable[B] {
    override def format(any: B): String = self.format(f(any))
  }
}

object Printable {
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
  import Printable._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
