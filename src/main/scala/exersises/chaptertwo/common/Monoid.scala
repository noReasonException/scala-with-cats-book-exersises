package co.uk.noreasonexception
package exersises.chaptertwo.common


trait Monoid[A] extends Semigroup[A]{
  def empty:A
}
object Monoid{
  implicit class MonoidOps[A](maybeMonoid:A){
    def combine(maybeAnother:A)(implicit monoidInstance:Semigroup[A]):A=monoidInstance.combine(maybeMonoid,maybeAnother)
  }
  def empty[A](implicit monoid: Monoid[A]) = monoid.empty
}
