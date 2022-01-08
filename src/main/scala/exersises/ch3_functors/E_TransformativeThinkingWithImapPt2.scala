package co.uk.noreasonexception
package exersises.ch3_functors

trait CodecE[A] { self =>
  def encode(value: A): String
  def decode(string: String): A
  def imap[B](dec: A => B, enc: B => A): CodecE[B] = new CodecE[B] {
    override def encode(value: B): String = self.encode(enc(value))
    override def decode(str: String): B = dec(self.decode(str))
  }
}

case class BoxE[A](value: A)

object CodecE {
  implicit val idCodec: CodecE[String] = new CodecE[String] {
    override def encode(value: String): String = value

    override def decode(string: String): String = string
  }

  def instance[A](implicit codec: CodecE[A]): CodecE[A] = codec

  implicit val intCodec: CodecE[Int] =
    instance[String].imap(strToInt => strToInt.toInt, int => int.toString)

  implicit def boxCodec[A](implicit innerCodec: CodecE[A]): CodecE[BoxE[A]] =
    instance[String].imap[BoxE[A]](
      str => BoxE(innerCodec.decode(str)),
      b => innerCodec.encode(b.value)
    )

  def encode[A](value: A)(implicit codec: CodecE[A]): String =
    codec.encode(value)
  def decode[A](value: String)(implicit codec: CodecE[A]): A =
    codec.decode(value)

}

object E_TransformativeThinkingWithImapPt2 {
  def main(args: Array[String]): Unit = {
    import CodecE._

    print(BoxE(12))

    print(decode[BoxE[Int]]("12"))
  }
}
