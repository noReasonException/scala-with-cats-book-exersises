package co.uk.noreasonexception
package exersises.ch3_functors

trait Printable2[A] {
  self =>
  def format(a: A): String
  def contraMap[B](f: B => A): Printable2[B] = new Printable2[B] {
    override def format(b: B): String = self.format(f(b))
  }
}
case class Box[A](a: A)

object Printable2 {
  implicit val intPrintable: Printable2[Int] = new Printable2[Int] {
    override def format(a: Int): String = a.toString
  }
  implicit def boxPrintable[A](implicit
      innerPrintable: Printable2[A]
  ): Printable2[Box[A]] = innerPrintable.contraMap[Box[A]](_.a)

  implicit class PrintableOps2[A](a: A) {
    def format(implicit printable: Printable2[A]): String = printable.format(a)

  }

  def instance[A](implicit printable: Printable2[A]): Printable2[A] = printable
}

object C_ShowingOffWithContramapPt2 {
  import Printable2._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
