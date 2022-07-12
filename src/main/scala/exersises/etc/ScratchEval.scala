package co.uk.noreasonexception
package exersises.etc
import cats.Eval

import math.random
object ScratchEval {

  def main(args: Array[String]): Unit = {
    print(factorial2(300000).value)
  }

  def factorial(n: BigInt): Eval[BigInt] = {
    if (n == 1) Eval.now(1) else Eval.defer(factorial(n - 1).map(_ * n))
  }
  def factorial2(n: BigInt): Eval[BigInt] = {
    if (n == 1) Eval.now(1) else Eval.later(factorial(n - 1).map(_ * n).value)
  }

}
