package co.uk.noreasonexception
package exersises.ch3_functors

trait Codec[A] { self =>
  def encode(value: A): String
  def decode(string: String): A
  def imap[B](dec: A => B, enc: B => A): Codec[B] = new Codec[B] {
    override def encode(value: B): String = self.encode(enc(value))
    override def decode(str: String): B = dec(self.decode(str))
  }
}

object Codec {
  implicit val idCodec: Codec[String] = new Codec[String] {
    override def encode(value: String): String = value

    override def decode(string: String): String = string
  }

  def instance[A](implicit codec: Codec[A]): Codec[A] = codec

  implicit val intCodec: Codec[Int] =
    instance[String].imap(strToInt => strToInt.toInt, int => int.toString)

  def encode[A](value: A)(implicit codec: Codec[A]): String =
    codec.encode(value)
  def decode[A](value: String)(implicit codec: Codec[A]): A =
    codec.decode(value)

}

object D_TransformativeThinkingWithImap {
  def main(args: Array[String]): Unit = {
    import Codec._
    print(decode[Int]("12") + 12)
  }
}
