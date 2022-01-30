package co.uk.noreasonexception
package exersises.ch4_monads

import cats.MonadError
import cats.instances.try_
import cats.instances.either._
import scala.util.Try

object D_MonadErrorExample {

  def validateAdult[F[_]](
      age: Int
  )(implicit me: MonadError[F, Throwable]): F[Int] = {
    if (age >= 18) me.pure(age)
    else
      me.raiseError(
        new IllegalArgumentException("Age must be greater than or equal to 18")
      )
  }
  def main(args: Array[String]): Unit = {

    type ExceptionOr[A] = Either[Throwable, A]

    println(validateAdult[Try](20))
    println(validateAdult[ExceptionOr](20))
  }
}
