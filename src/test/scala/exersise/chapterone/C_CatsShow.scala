package co.uk.noreasonexception
package exersise.chapterone

import exersises.chapterone.{Cat, Cat2, Printable, PrintableInstances}

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.Show
import cats.syntax.show._

class C_CatsShow extends AnyFlatSpec with should.Matchers {

  import exersises.chapterone.Cat2._

  "A cat" should "be able to formatted correctly" in {
    val cat = Cat2("Zuko", 1, "Black and white")
    cat.show shouldBe "Zuko is a 1 year-old Black and white cat"

  }
}
