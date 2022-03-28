package co.uk.noreasonexception
package exersise.ch4_monads

import exersises.ch4_monads.Db

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

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
//  TODO Implement stack safety and invalid expression detection
//  "EvaluatePostOrder" should "evaluate a invalid expression correctly" in {
//    val expression = "+ +"
//    evaluatePostOrder(expression) shouldBe 0
//  }
}
