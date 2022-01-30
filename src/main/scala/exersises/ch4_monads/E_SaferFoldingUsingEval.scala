package co.uk.noreasonexception
package exersises.ch4_monads

import cats.Eval

import scala.annotation.tailrec

object E_SaferFoldingUsingEval {

  //trivial stack-safe fold
  @tailrec
  def trivialFold[A, B](list: List[A], acc: B)(f: (A, B) => B): B = {
    list match {
      case ::(head, next) => trivialFold(next, f(head, acc))(f)
      case Nil => acc
    }
  }
  //trivial non-stack-safe fold

  def trivialNonStackSafeFold[A, B](list: List[A], acc: B)(
      f: (A, B) => B
  ): B = {
    list match {
      case ::(head, next) =>
        f(head, trivialNonStackSafeFold(next, f(head, acc))(f))
      case Nil => acc
    }
  }
  //stack-safe fold
  def stackSafeFold[A, B](list: List[A], acc: B)(f: (A, B) => B): B = {
    def stackSafeFoldEval(list: List[A], acc: B)(f: (A, B) => B): Eval[B] = {
      list match {
        case ::(head, next) =>
          Eval.defer(stackSafeFoldEval(next, f(head, acc))(f))
        case Nil => Eval.now(acc)
      }
    }
    stackSafeFoldEval(list, acc)(f).value
  }
  def main(args: Array[String]): Unit = {
    //val list = (0 to 500000000).toList // endless loop
    val list = (0 to 50000).toList //fails
    print(stackSafeFold(list, 0)(_ + _))
  }
}
