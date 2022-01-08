package co.uk.noreasonexception
package exersises.ch3_functors

trait PrintableC[A] {
  self =>
  def format(any: A): String
  def contraMap[B](f: B => A): PrintableC[B] = new PrintableC[B] {
    override def format(any: B): String = self.format(f(any))
  }
}
case class Box[A](value: A)

object PrintableC {
  implicit val intPrintable: PrintableC[Int] = new PrintableC[Int] {
    override def format(value: Int): String = value.toString
  }
  implicit def boxPrintable[A](implicit
      innerPrintable: PrintableC[A]
  ): PrintableC[Box[A]] = innerPrintable.contraMap[Box[A]](_.value)

  implicit class PrintableOps2[A](value: A) {
    def format(implicit printable: PrintableC[A]): String =
      printable.format(value)

  }

  def instance[A](implicit printable: PrintableC[A]): PrintableC[A] = printable
}

object C_ShowingOffWithContramapPt2 {
  import PrintableC._
  def main(args: Array[String]): Unit = {
    print(12.format)

  }
}
