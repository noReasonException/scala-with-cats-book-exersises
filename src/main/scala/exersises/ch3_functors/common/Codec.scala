package co.uk.noreasonexception
package exersises.ch3_functors.common

trait Codec[A] { self =>
  def encode(value: A): String
  def decode(string: String): A
  def imap[B](dec: A => B, enc: B => A): Codec[B] = new Codec[B] {
    override def encode(value: B): String = self.encode(enc(value))
    override def decode(str: String): B = dec(self.decode(str))
  }
}
