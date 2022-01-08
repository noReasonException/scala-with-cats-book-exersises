package co.uk.noreasonexception
package exersise.ch2_monoids_semigroups

import exersises.ch2_monoids_semigroups._
import exersises.ch2_monoids_semigroups.common.Monoid

import org.scalatest.flatspec._
import org.scalatest.matchers._
import co.uk.noreasonexception.exersises.ch2_monoids_semigroups.common.Semigroup._
class B_TruthAboutSets extends AnyFlatSpec with should.Matchers {

  "A UnionMonad" should "combine two sets" in {
    import SetMonoids._
    import Monoid._
    val first: Set[Int] = (1 :: 2 :: Nil).toSet
    val second: Set[Int] = (2 :: 3 :: Nil).toSet

    first.combine(second) shouldEqual Set(1, 2, 3)

  }
  "A UnionMonad" should "obey Identity Law" in {
    import Monoid._
    import SetMonoids._
    val set: Set[Int] = (1 :: 2 :: Nil).toSet

    set.combine(Monoid.empty[Set[Int]]) shouldEqual set
    Monoid.empty[Set[Int]].combine(set) shouldEqual set
  }

  "A UnionMonad" should "obey Associative Law" in {
    import Monoid._
    import SetMonoids._

    val first: Set[Int] = (1 :: 2 :: Nil).toSet
    val second: Set[Int] = (2 :: 3 :: Nil).toSet

    first.combine(second.combine(Monoid.empty[Set[Int]])) shouldEqual first
      .combine(second)
      .combine(Monoid.empty[Set[Int]])

  }

  "A SemigroupIntersection" should "intersect two sets" in {
    import SetSemigroups._
    import Monoid._
    val first: Set[Int] = (1 :: 2 :: Nil).toSet
    val second: Set[Int] = (2 :: 3 :: Nil).toSet

    first.combine(second) shouldEqual Set(2)

  }
  "A SemigroupIntersection" should "obey Associative Law" in {
    import Monoid._
    import SetSemigroups._

    val first: Set[Int] = (1 :: 2 :: Nil).toSet
    val second: Set[Int] = (2 :: 3 :: Nil).toSet
    val third: Set[Int] = (2 :: 3 :: Nil).toSet

    first.combine(second.combine(third)) shouldEqual (first
      .combine(second))
      .combine(third)

  }

}
