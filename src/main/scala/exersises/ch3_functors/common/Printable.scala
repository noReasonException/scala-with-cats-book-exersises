package co.uk.noreasonexception
package exersises.ch3_functors.common

trait Printable[-A] {
  self =>
  def format(value: A): String
  def contraMap[B](f: B => A): Printable[B] = new Printable[B] {
    override def format(any: B): String = self.format(f(any))
  }
}
