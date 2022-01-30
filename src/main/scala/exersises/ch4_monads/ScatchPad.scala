package co.uk.noreasonexception
package exersises.ch4_monads

import exersises.ch4_monads.common.Monad

trait MonadError[F[_], E] extends Monad[F] {
  def raiseError[A](e: E): F[A]
  // Handle an error, potentially recovering from it:
  def handleErrorWith[A](fa: F[A])(f: E => F[A]): F[A]
  // Handle all errors, recovering from them:
  def handleError[A](fa: F[A])(f: E => A): F[A]
  // Test an instance of `F`,
  // failing if the predicate is not satisfied:
  def ensure[A](fa: F[A])(e: E)(f: A => Boolean): F[A]
}

//object MonadErrorInstancesD {
//  type ErrorOr[A] = Either[Throwable, A]
//
//  implicit def errorOrMonadError[A]: MonadError[ErrorOr, A] =
//    new MonadError[ErrorOr, A] {
//      override def raiseError[A](e: A): ErrorOr[A] = ???
//
//      override def handleErrorWith[A](fa: ErrorOr[A])(
//          f: A => ErrorOr[A]
//      ): ErrorOr[A] = ???
//
//      override def handleError[A](fa: ErrorOr[A])(f: A => A): ErrorOr[A] = ???
//
//      override def ensure[A](fa: ErrorOr[A])(e: A)(
//          f: A => Boolean
//      ): ErrorOr[A] = ???
//
//      override def pure[A](value: A): ErrorOr[A] = Right(value)
//
//      override def flatMap[A, B](
//          value: ErrorOr[A]
//      )(f: A => ErrorOr[B]): ErrorOr[B] = {
//        value match {
//          case Right(value) => f(value)
//          case _ => _
//        }
//      }
//    }
//}
