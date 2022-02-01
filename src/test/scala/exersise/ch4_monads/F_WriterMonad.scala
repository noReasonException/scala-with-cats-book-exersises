package co.uk.noreasonexception
package exersise.ch4_monads

import exersises.ch4_monads.E_SaferFoldingUsingEval._

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.util.{Failure, Success, Try}

class F_WriterMonad extends AnyFlatSpec with should.Matchers {

  import co.uk.noreasonexception.exersises.ch4_monads.F_WriterMonad.factorial
  "Writer Monad Factorial" should "return proper results and logs" in {
    val result = factorial(5)
    result.value shouldBe 120
    result.written.length shouldBe 5
  }
}
