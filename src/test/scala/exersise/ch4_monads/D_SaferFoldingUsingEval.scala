package co.uk.noreasonexception
package exersise.ch4_monads

import exersises.ch4_monads.D_SaferFoldingUsingEval._

import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.util.{Failure, Success, Try}

class D_SaferFoldingUsingEval extends AnyFlatSpec with should.Matchers {

  //You cannot catch Errors with Try, only Exceptions
  def catchStackOverflowError[A,B](f:()=>B):Try[B]={
    try{
      Success(f())
    }catch {
      case e:StackOverflowError=>Failure(e)
    }
  }

  "Trivial tail-recursive fold" should "not blow up the stack" in {
    val list = (0 to 50000).toList //fails
    catchStackOverflowError(()=>trivialFold(list,0)(_+_)).toEither shouldBe Right(list.sum)
  }
  "Trivial non-tail-recursive fold" should "blow up the stack" in {
    val list = (0 to 50000).toList //fails
    catchStackOverflowError(()=>trivialNonStackSafeFold(list,0)(_+_)).isSuccess shouldBe false
  }
  "Eval fold" should "not blow up the stack" in {
    val list = (0 to 50000).toList //fails
    catchStackOverflowError(()=>stackSafeFold(list,0)(_+_)).toEither shouldBe Right(list.sum)
  }
}
