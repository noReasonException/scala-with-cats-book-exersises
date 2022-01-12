package co.uk.noreasonexception
package exersise.ch1_introduction

import exersises.ch1_introduction.{Printable, PrintableInstancesB}

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.Show
import cats.syntax.show._
import co.uk.noreasonexception.exersises.ch1_introduction.common.Cat

class C_CatsShow extends AnyFlatSpec with should.Matchers {

  "A cat" should "be able to formatted correctly" in {
    import exersises.ch1_introduction.CatInstancesC._
    val cat = Cat("Zuko", 1, "Black and white")
    cat.show shouldBe "Zuko is a 1 year-old Black and white cat"

  }
}
