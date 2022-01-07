package C_3_6_2

//trait
//instances
//syntax

final case class Box[A](element: A)

trait Codec[A] { self =>
  def encode(element: A): String
  def decode(element: String): A

  /** * if i do not define this here, the definition of every Codec will be
    * impossible , because Codec[A] will require Codec[B] and this will require
    * Codec[C] ...??
    */
  def imap[B](dec: A => B, enc: B => A): Codec[B] = new Codec[B] {
    override def encode(element: B): String = self.encode(enc(element))
    override def decode(element: String): B = dec(self.decode(element))
  }
}

object Instances {
  implicit val strCodec: Codec[String] = new Codec[String] {
    override def encode(element: String): String = element
    override def decode(element: String): String = element
  }
  implicit def boxCodec[A](implicit boxedCodec: Codec[A]): Codec[Box[A]] =
    new Codec[Box[A]] {
      override def encode(element: Box[A]): String =
        boxedCodec.encode(element.element)

      override def decode(element: String): Box[A] = Box(
        boxedCodec.decode(element)
      )
    }
}

/** Note that the decode method of our Codec type class doesn’t account for
  * failures. If we want to model more sophisticated relationships we can move
  * beyond functors to look at lenses and optics.
  */
object Main {
  import Instances._

  val strToDouble: String => Double = s => s.toDouble
  val doubleToStr: Double => String = s => s.toString
  implicit val doubleCodec = strCodec.imap(strToDouble, doubleToStr)

  def main(args: Array[String]): Unit = {
    val box = Box(12.2)
    print(boxCodec[Double].encode(box))
  }
}
