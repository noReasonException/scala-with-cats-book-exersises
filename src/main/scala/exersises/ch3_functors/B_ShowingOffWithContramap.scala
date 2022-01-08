package co.uk.noreasonexception
package exersises.ch3_functors

trait Printable[A] {
  self =>
  def format(a: A): String
  def contraMap[B](f: B => A): Printable[B] = new Printable[B] {
    override def format(b: B): String = self.format(f(b))
  }
}

object Printable {
  implicit val intPrintable: Printable[Int] = new Printable[Int] {
    override def format(a: Int): String = a.toString
  }
  implicit val strPrintable: Printable[String] = new Printable[String] {
    override def format(a: String): String = a
  }

  implicit class PrintableOps[A](a: A) {
    def format(implicit printable: Printable[A]): String = printable.format(a)

  }

  def instance[A](implicit printable: Printable[A]): Printable[A] = printable
}

object B_ShowingOffWithContramap {
  import Printable._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
