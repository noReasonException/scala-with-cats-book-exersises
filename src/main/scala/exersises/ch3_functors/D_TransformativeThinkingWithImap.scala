package co.uk.noreasonexception
package exersises.ch3_functors

import exersises.ch3_functors.common.Codec

object CodecInstancesD {
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
    import CodecInstancesE._
    print(decode[Int]("12") + 12)
  }
}
