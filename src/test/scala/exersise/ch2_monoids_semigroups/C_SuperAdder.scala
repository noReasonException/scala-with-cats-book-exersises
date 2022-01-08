package co.uk.noreasonexception
package exersise.ch2_monoids_semigroups

import exersises.ch2_monoids_semigroups._
import exersises.ch2_monoids_semigroups.common.Monoid
import exersises.ch2_monoids_semigroups.common.Semigroup._

import org.scalatest.flatspec._
import org.scalatest.matchers._

class C_SuperAdder extends AnyFlatSpec with should.Matchers {

  "AdderV1" should "add Numbers" in {
    import Adder._
    addV1(List(1, 2, 3)) shouldBe 6
  }
  "AdderV2" should "add Numbers" in {
    import Adder._
    addV2(List(1, 2, 3)) shouldBe 6
  }
  "AdderV2" should "add Option of numbers" in {
    import Adder._
    addV2(List(Some(1), None, Some(3), Some(2))) shouldBe Some(6)
  }
  "AdderV2" should "add Orders" in {
    import Adder._
    addV2(List(Order(1, 1), Order(2, 2))) shouldBe Order(3, 3)
  }
  "AdderV2" should "add Options of Orders" in {
    import Adder._
    addV2(List(Some(Order(1, 1)), None, Some(Order(2, 2)))) shouldBe Some(
      Order(3, 3)
    )
  }

}
