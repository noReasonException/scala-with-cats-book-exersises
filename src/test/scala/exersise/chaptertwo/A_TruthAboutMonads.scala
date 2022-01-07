package co.uk.noreasonexception
package exersise.chaptertwo

import co.uk.noreasonexception.exersises.chaptertwo._
import org.scalatest.flatspec._
import org.scalatest.matchers._
import co.uk.noreasonexception.exersises.chaptertwo.common.Monoid
import co.uk.noreasonexception.exersises.chaptertwo.common.Semigroup._
class A_TruthAboutMonads extends AnyFlatSpec with should.Matchers {

  "A AndMonad" should "obey And truth table" in {
    import Monoid._
    import MonoidAnd._

    false.combine(false) shouldEqual false
    false.combine(true) shouldEqual false
    true.combine(false) shouldEqual false
    true.combine(true) shouldEqual true
  }
  "A AndMonad" should "obey Identity Law" in {
    import Monoid._
    import MonoidAnd._

    true.combine(Monoid.empty[Boolean]) shouldEqual true
    false.combine(Monoid.empty[Boolean]) shouldEqual false

  }
  "A AndMonad" should "obey Associative Law" in {
    import Monoid._
    import MonoidAnd._

    true.combine(false.combine(true)) shouldEqual (true
      .combine(false)
      .combine(true))

  }
//----
  "A OrMonad" should "obey Or truth table" in {
    import Monoid._
    import MonoidOr._

    false.combine(false) shouldEqual false
    false.combine(true) shouldEqual true
    true.combine(false) shouldEqual true
    true.combine(true) shouldEqual true
  }
  "A OrMonad" should "obey Identity Law" in {
    import Monoid._
    import MonoidOr._

    true.combine(Monoid.empty[Boolean]) shouldEqual true
    false.combine(Monoid.empty[Boolean]) shouldEqual false

  }
  "A OrMonad" should "obey Associative Law" in {
    import Monoid._
    import MonoidOr._

    true.combine(false.combine(true)) shouldEqual (true
      .combine(false)
      .combine(true))

  }
  //----
  "A XorMonad" should "obey Xor truth table" in {
    import Monoid._
    import MonoidXor._

    false.combine(false) shouldEqual false
    false.combine(true) shouldEqual true
    true.combine(false) shouldEqual true
    true.combine(true) shouldEqual false
  }
  "A XorMonad" should "obey Identity Law" in {
    import Monoid._
    import MonoidXor._

    true.combine(Monoid.empty[Boolean]) shouldEqual true
    false.combine(Monoid.empty[Boolean]) shouldEqual false

  }
  "A XorMonad" should "obey Associative Law" in {
    import Monoid._
    import MonoidXor._

    true.combine(false.combine(true)) shouldEqual (true
      .combine(false)
      .combine(true))

  }
  "A XNorMonad" should "obey XNor truth table" in {
    import Monoid._
    import MonoidXNor._

    false.combine(false) shouldEqual true
    false.combine(true) shouldEqual false
    true.combine(false) shouldEqual false
    true.combine(true) shouldEqual true
  }
  "A XNorMonad" should "obey Identity Law" in {
    import Monoid._
    import MonoidXNor._

    true.combine(Monoid.empty[Boolean]) shouldEqual true
    false.combine(Monoid.empty[Boolean]) shouldEqual false

  }
  "A XNorMonad" should "obey Associative Law" in {
    import Monoid._
    import MonoidXNor._

    true.combine(false.combine(true)) shouldEqual (true
      .combine(false)
      .combine(true))

  }
}
