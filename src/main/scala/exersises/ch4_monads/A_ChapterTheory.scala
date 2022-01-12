package co.uk.noreasonexception
package exersises.ch4_monads

import cats.Monad
import cats.syntax.functor._
import cats.syntax.flatMap._
import cats.Id
object SumQuare {
  def sumQuare[F[_]: Monad](x: F[Int], y: F[Int]): F[Int] = {
    for {
      a <- x
      b <- y
    } yield a + b
  }
}

object Main {
  import SumQuare._
  def main(args: Array[String]): Unit = {
    println(
      sumQuare(
        List(1, 2, 3),
        List(3, 4, 5)
      )
    )
    println(
      sumQuare[Option](
        Some(1),
        Some(6)
      )
    )
    println(
      sumQuare[Id](
        5,
        8
      )
    )
  }
}
