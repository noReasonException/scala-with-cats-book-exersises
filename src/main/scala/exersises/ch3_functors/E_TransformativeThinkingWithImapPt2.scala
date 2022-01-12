package co.uk.noreasonexception
package exersises.ch3_functors

import exersises.ch3_functors.common.Codec

case class BoxE[A](value: A)

object CodecInstancesE {
  implicit val idCodec: Codec[String] = new Codec[String] {
    override def encode(value: String): String = value

    override def decode(string: String): String = string
  }

  def instance[A](implicit codec: Codec[A]): Codec[A] = codec

  implicit val intCodec: Codec[Int] =
    instance[String].imap(strToInt => strToInt.toInt, int => int.toString)

  implicit def boxCodec[A](implicit innerCodec: Codec[A]): Codec[BoxE[A]] =
    instance[String].imap[BoxE[A]](
      str => BoxE(innerCodec.decode(str)),
      b => innerCodec.encode(b.value)
    )

  def encode[A](value: A)(implicit codec: Codec[A]): String =
    codec.encode(value)
  def decode[A](value: String)(implicit codec: Codec[A]): A =
    codec.decode(value)

}

object E_TransformativeThinkingWithImapPt2 {
  def main(args: Array[String]): Unit = {
    import CodecInstancesE._

    print(BoxE(12))

    print(decode[BoxE[Int]]("12"))
  }
}
