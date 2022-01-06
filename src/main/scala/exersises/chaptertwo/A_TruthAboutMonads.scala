package co.uk.noreasonexception
package exersises.chaptertwo


/**
 * Type class
 * Implementations
 * Interface Object or Interface Syntax
 *
 */

trait Semigroup[A]{
  def combine(first:A,second:A):A
}
trait Monoid[A] extends Semigroup[A]{
  def empty:A
}

object MonoidAnd{
  implicit val andMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(first: Boolean, second: Boolean): Boolean = first&&second
  }
}
object MonoidOr{
  implicit val orMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(first: Boolean, second: Boolean): Boolean = first||second
  }
}
object MonoidXor{
  implicit val xorMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(first: Boolean, second: Boolean): Boolean = first^second
  }
}
object MonoidXNor{
  implicit val xorMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(first: Boolean, second: Boolean): Boolean = !(first^second)
  }
}
object Monoid{
  implicit class MonoidOps[A](maybeMonoid:A){
    def combine(maybeAnother:A)(implicit monoidInstance:Monoid[A]):A=monoidInstance.combine(maybeMonoid,maybeAnother)
  }
  def empty[A](implicit monoid: Monoid[A]) = monoid.empty
}



object A_TruthAboutMonads {
  import Monoid._
  import MonoidAnd._

  def main(args: Array[String]): Unit = {
    print(true.combine(false).combine(empty))
  }

}
