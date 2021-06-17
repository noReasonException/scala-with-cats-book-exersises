package C_3_6_2

//trait
//instances
//syntax

trait Codec[A] { self=>
  def encode(element:A):String
  def decode(element:String):A

  /***
   * if i do not define this here, the definition of every Codec will be impossible , because
   * Codec[A] will require Codec[B] and this will require Codec[C] ...??
   */
  def imap[B](dec:A=>B,enc:B=>A):Codec[B] = new Codec[B] {
    override def encode(element: B): String = self.encode(enc(element))
    override def decode(element: String): B = dec(self.decode(element))
  }
}

object Instances{
  implicit val StrCodec:Codec[String]=new Codec[String] {
    override def encode(element: String): String = element

    override def decode(element: String): String = element

  }
}

object Syntax{

}
object Main{
  def main(args: Array[String]): Unit = {
    print("hello world")
  }
}

