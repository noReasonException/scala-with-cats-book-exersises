package co.uk.noreasonexception
package exersises.chaptertwo

import exersises.chaptertwo.common.{Monoid, Semigroup}

/**
 * Sets common operations
 *  Union                   Definetely a semigroup, monoid with empty set
 *  Complement              Cannot be a monoid as it involves only one Set(And the reference frame Omega)
 *  Intersection            Definetely a semigroup, monoid with Omega, but Omega not available
 *  Difference              Unlawful (Difference is not ascociative)
 */


object SetMonoids{
  implicit def unionMonoid[A]:Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty[A]
    override def combine(first: Set[A], second: Set[A]): Set[A] = first.union(second)
  }
}
object SetSemigroups{
  implicit def semigroupIntersection[A]:Semigroup[Set[A]] = new Semigroup[Set[A]] {
    override def combine(first: Set[A], second: Set[A]): Set[A] = first.intersect(second)
  }
}


object B_TruthAboutSets {
  import Monoid._
  import MonoidAnd._

  def main(args: Array[String]): Unit = {
    print(true.combine(false).combine(empty))
  }

}
