package co.uk.noreasonexception
package exersises.ch4_monads.common

import cats.data.Writer
import cats.implicits.{catsSyntaxApplicativeId, catsSyntaxTuple2Semigroupal}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object G_ReaderMonad {
  private def slowly[B](f: => B): B = {
    try f
    finally Thread.sleep(100)
  }

  type LoggedResult[A] = Writer[Vector[String], A]
  def factorial(n: Int): LoggedResult[Int] = {
    def _factorial(n: LoggedResult[Int]): LoggedResult[Int] = {
      if (n.value == 0) n.map(_ => 1)
      else {
        slowly(_factorial(n.map(_ - 1))).bimap(
          a => a ++ Vector("f(" + n.value + ")"),
          b => b * n.value
        )
      }
    }
    _factorial(n.pure[LoggedResult])
  }

  def main(args: Array[String]): Unit = {
    Await.result(
      (
        {
          Future {
            factorial(5)
          }
        }, {
          Future {
            factorial(10)
          }
        }
      ).mapN((a, b) => {
        //tidy logs
        println(a.written.mkString("\n"))
        println(a.value)
        println(b.written.mkString("\n"))
        println(b.value)
      }),
      5 seconds
    )

  }
}
