package co.uk.noreasonexception
package exersise.ch4_monads

import exersises.ch4_monads.Db

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should
import cats.implicits._
class H_PostOrderWithStateMonad extends AnyFlatSpec with should.Matchers {

  import exersises.ch4_monads.H_PostOrderWithStateMonad.evaluatePostOrder

  "EvaluatePostOrder" should "evaluate a trivial expression correctly" in {
    val expression = "1 2 + 3 + 6 +"
    evaluatePostOrder(expression) shouldBe 12
  }
  "EvaluatePostOrder" should "evaluate a non-terminating trivial expression correctly" in {
    val expression = "1 2 + 3 + 6 "
    evaluatePostOrder(expression) shouldBe 6
  }

}
