package co.uk.noreasonexception
package exersise.chapterone

import co.uk.noreasonexception.exersises.chapterone.{
  Cat,
  JsNull,
  JsString,
  Json,
  JsonWriterInstances,
  Printable,
  PrintableInstances
}
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.collection.mutable.Stack

class B_PrintableLibrary extends AnyFlatSpec with should.Matchers {

  import PrintableInstances._
  import Printable._
  "A cat" should "be able to formatted correctly" in {
    val cat = Cat("Zuko", 1, "Black and white")
    cat.format shouldBe "Zuko is a 1 year-old Black and white cat"

  }
}
