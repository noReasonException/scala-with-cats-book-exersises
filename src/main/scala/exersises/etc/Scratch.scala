import cats.{Applicative, MonadError}

import cats.syntax.applicative._          // .pure
import cats.syntax.monadError._
import cats.syntax.either._               // .asRight[Throwable]
import cats.syntax.applicativeError._     //.attempt
object main{
  import cats.instances.either
  type ErrorOr[A] = Either[Throwable,A]
  type MonadErrorWithThrowable[F[_]] = MonadError[F,Throwable]
  def main(args:Array[String]):Unit={

    println(test[ErrorOr,String])

  }
  def test[F[_]:Applicative:MonadErrorWithThrowable,A]:F[Int] ={
    val valueInEffect: F[Either[Throwable, Int]] = 12.asRight[Throwable].pure[F]
    val liftIntoEffect:F[Int] = valueInEffect.rethrow
    val bringIntoType:F[Either[Throwable,Int]] = liftIntoEffect.attempt
    bringIntoType.rethrow
  }

}