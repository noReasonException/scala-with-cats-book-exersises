package co.uk.noreasonexception
package exersise.ch4_monads

import exersises.ch4_monads.E_SaferFoldingUsingEval._

import co.uk.noreasonexception.exersises.ch4_monads.D_MonadErrorExample.validateAdult
import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.util.{Failure, Success, Try}

class D_MonadErrorExample extends AnyFlatSpec with should.Matchers {

  type ExceptionOr[A] = Either[Throwable, A]

  "validateAdult[Try] with 5" should "Return Failure" in {
    validateAdult[Try](5).isFailure shouldBe true
  }
  "validateAdult[Try] with 30" should "Return Success" in {
    validateAdult[Try](30).isSuccess shouldBe true
  }
  "validateAdult[ExceptionOr] with 5" should "Return Left" in {
    validateAdult[ExceptionOr](5).isLeft shouldBe true
  }
  "validateAdult[ExceptionOr] with 30" should "Return Right" in {
    validateAdult[ExceptionOr](30).isRight shouldBe true
  }
}
