package co.uk.noreasonexception
package exersises.ch4_monads.common

//┌────────────────┐              ┌────────────────┐
//│                │              │                │
//│                │              │                │
//│  Monoid        ├──────────────►  cats.FlatMap  │
//│                │              │      .flatMap()│
//│                │              │                │
//│                │              │                │
//└────────┬───────┘              └────────────────┘
//         │
//         │
//         │
//         │                      ┌────────────────┐            ┌────────────────┐
//         │                      │                │            │                │
//         │                      │                │            │                │
//         │                      │  Applicative   │            │  Functor       │
//         └──────────────────────►      .pure()   ├────────────►      .map()    │
//                                │                │            │                │
//                                │                │            │                │
//                                └────────────────┘            └────────────────┘

trait Monad[F[_]] {
  def pure[A](value: A): F[A]
  def flatMap[A, B](value: F[A])(f: A => F[B]): F[B]
  def map[A, B](value: F[A])(f: A => B): F[B] = flatMap(value)(f.andThen(pure))
}

object Monad {
  def pure[F[_], A](value: A)(implicit m: Monad[F]) = m.pure(value)
  implicit class MonadOps[F[_], A](value: F[A]) {
    def flatMap[B](f: A => F[B])(implicit monad: Monad[F]): F[B] = {
      monad.flatMap(value)(f)
    }
  }
}
