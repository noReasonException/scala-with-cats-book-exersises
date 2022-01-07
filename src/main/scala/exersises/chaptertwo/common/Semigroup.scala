package co.uk.noreasonexception
package exersises.chaptertwo.common

trait Semigroup[A] {
  def combine(first: A, second: A): A
}
object Semigroup {
  implicit class SemigroupOps[A](obj1: A) {
    def combine(obj2: A)(implicit monoidInstance: Semigroup[A]): A =
      monoidInstance.combine(obj1, obj2)
  }
}
