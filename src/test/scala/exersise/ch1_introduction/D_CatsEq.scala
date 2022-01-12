package co.uk.noreasonexception
package exersise.ch1_introduction

import cats.syntax.show._
import co.uk.noreasonexception.exersises.ch1_introduction.common.Cat
import org.scalatest.flatspec._
import org.scalatest.matchers._

class D_CatsEq extends AnyFlatSpec with should.Matchers {

  "A cat" should "be able to compared correctly(inequality)" in {
    val zuko = Cat("Zuko", 1, "Black and white")
    val garfield = Cat("Garfield", 2, "Orange")
    zuko === garfield shouldBe false
  }
  "A cat" should "be able to compared correctly(equallity)" in {
    val zuko = Cat("Zuko", 1, "Black and white")
    val zukoAgain = Cat("Zuko", 1, "Black and white")
    zuko === zukoAgain shouldBe true
  }
}
