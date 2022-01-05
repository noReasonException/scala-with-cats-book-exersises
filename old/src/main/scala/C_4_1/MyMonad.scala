package C_4_1


//trait
//instances
//syntax


sealed trait MyMonad[F[_]]{
  def pure[A](a:A):F[A]
  def flatMap[A,B](src:F[A])(fn:A=>F[B]):F[B]
  def map[A,B](src:F[A])(fn:A=>B):F[B]=flatMap(src)(x=>pure(fn(x)))
}



sealed trait MyOption[+A]
final case object MyNone extends MyOption[Nothing]
final case class MySome[A](value:A) extends MyOption[A]
object MyOption{
  def some[A](a:A):MyOption[A]=MySome(a)
  def none:MyOption[Nothing]=MyNone
}

object MonadInstances {
  implicit val myOptionMonadInstance: MyMonad[MyOption] =new MyMonad[MyOption] {
    override def pure[A](a: A): MyOption[A] = MySome(a)

    override def flatMap[A, B](src: MyOption[A])(fn: A => MyOption[B]): MyOption[B] = src match {
      case MyNone=>MyNone
      case MySome(value) => fn(value)
    }
  }
}

object MonadOps{
  implicit class MyOptionMonadOps[A](src:MyOption[A]){
      def flatMap[B](fn: A => MyOption[B])(implicit monad: MyMonad[MyOption]): MyOption[B]= monad.flatMap(src)(fn)
      def map[B](fn:A=>B)(implicit monad:MyMonad[MyOption]):MyOption[B]=monad.map(src)(fn)

  }
}

object MainC41A{
  import MonadInstances._
  import MonadOps._

  def main(args: Array[String]): Unit = {
    val some12:MyOption[Int]=MyOption.some(12)
    val none:MyOption[Int]=MyOption.some(20)

    print{
      for{
        a <- some12
        b<-none
      }yield b+a
    }
  }
}