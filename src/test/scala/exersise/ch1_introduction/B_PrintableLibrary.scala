package co.uk.noreasonexception
package exersise.ch1_introduction

import co.uk.noreasonexception.exersises.ch1_introduction.common.Cat
import co.uk.noreasonexception.exersises.ch1_introduction.{
  JsNull,
  JsString,
  Json,
  JsonWriterInstances,
  Printable,
  PrintableInstancesB
}
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.collection.mutable.Stack

class B_PrintableLibrary extends AnyFlatSpec with should.Matchers {

  import PrintableInstancesB._
  import Printable._
  "A cat" should "be able to formatted correctly" in {
    val cat = Cat("Zuko", 1, "Black and white")
    cat.format shouldBe "Zuko is a 1 year-old Black and white cat"

  }
}
