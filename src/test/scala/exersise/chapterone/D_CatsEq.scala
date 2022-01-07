package co.uk.noreasonexception
package exersise.chapterone

import exersises.chapterone.{Cat2, Cat3}

import cats.syntax.show._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class D_CatsEq extends AnyFlatSpec with should.Matchers {

  "A cat" should "be able to compared correctly(inequality)" in {
    val zuko = Cat3("Zuko", 1, "Black and white")
    val garfield = Cat3("Garfield", 2, "Orange")
    zuko === garfield shouldBe false
  }
  "A cat" should "be able to compared correctly(equallity)" in {
    val zuko = Cat3("Zuko", 1, "Black and white")
    val zukoAgain = Cat3("Zuko", 1, "Black and white")
    zuko === zukoAgain shouldBe true
  }
}
