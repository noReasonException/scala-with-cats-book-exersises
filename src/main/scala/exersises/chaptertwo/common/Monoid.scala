package co.uk.noreasonexception
package exersises.chaptertwo.common

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}
object Monoid {
  def empty[A](implicit monoid: Monoid[A]) = monoid.empty
}
