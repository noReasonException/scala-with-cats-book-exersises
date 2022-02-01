package co.uk.noreasonexception

import exersises.ch4_monads.E_SaferFoldingUsingEval._

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.util.{Failure, Success, Try}

class Letter_Description extends AnyFlatSpec with should.Matchers {

  "Template" should "follow universal logic" in {
    true shouldBe true
  }
}
