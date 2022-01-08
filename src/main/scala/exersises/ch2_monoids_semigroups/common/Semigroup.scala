package co.uk.noreasonexception
package exersises.ch2_monoids_semigroups.common

trait Semigroup[A] {
  def combine(first: A, second: A): A
}
object Semigroup {
  implicit class SemigroupOps[A](first: A) {
    def combine(second: A)(implicit monoidInstance: Semigroup[A]): A =
      monoidInstance.combine(first, second)
  }
}
