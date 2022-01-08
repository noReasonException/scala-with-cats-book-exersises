package co.uk.noreasonexception
package exersises.ch2_monoids_semigroups.common

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}
object Monoid {
  def empty[A](implicit monoid: Monoid[A]) = monoid.empty
}
