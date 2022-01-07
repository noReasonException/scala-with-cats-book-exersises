package C_4_3

import C_4_3.MyId.MyId

//trait
//instances
//syntax

sealed trait MyMonad[F[_]] {
  def pure[A](a: A): F[A]
  def flatMap[A, B](src: F[A])(fn: A => F[B]): F[B]
  def map[A, B](src: F[A])(fn: A => B): F[B] = flatMap(src)(x => pure(fn(x)))
}

object MyId {
  type MyId[A] = A

  implicit class MyIdOps[A](src: A) {
    def lift(): MyId[A] = src
  }
}

sealed trait MyOption[+A]
final case object MyNone extends MyOption[Nothing]
final case class MySome[A](value: A) extends MyOption[A]
object MyOption {
  def some[A](a: A): MyOption[A] = MySome(a)
  def none: MyOption[Nothing] = MyNone
}

object MonadInstances {
  implicit val myOptionMonadInstance: MyMonad[MyOption] =
    new MyMonad[MyOption] {
      override def pure[A](a: A): MyOption[A] = MySome(a)

      override def flatMap[A, B](
          src: MyOption[A]
      )(fn: A => MyOption[B]): MyOption[B] = src match {
        case MyNone => MyNone
        case MySome(value) => fn(value)
      }
    }
  implicit val myIdMonadInstance: MyMonad[MyId.MyId] = new MyMonad[MyId] {
    override def pure[A](a: A): MyId[A] = a
    override def flatMap[A, B](src: MyId[A])(fn: A => MyId[B]): MyId[B] = fn(
      src
    )
  }
}

object MyMonadOps {
  implicit class MyOptionMonadOps[F[_], A](src: F[A]) {
    def flatMap[B](fn: A => F[B])(implicit monad: MyMonad[F]): F[B] =
      monad.flatMap(src)(fn)
    def map[B](fn: A => B)(implicit monad: MyMonad[F]): F[B] =
      monad.map(src)(fn)
  }
}

object MainC43A {
  import MonadInstances._
  import MyMonadOps._
  import MyId._

  def addition[F[_]](a: F[Int], b: F[Int])(implicit
      myMonad: MyMonad[F]
  ): F[Int] = for {
    one <- a
    two <- b
  } yield one + two

  def main(args: Array[String]): Unit = {
    val some12: MyOption[Int] = MyOption.some(12)
    val none: MyOption[Int] = MyOption.some(20)

    println(addition(some12, none))
    println(addition(12.lift(), 2.lift()))
  }
}
