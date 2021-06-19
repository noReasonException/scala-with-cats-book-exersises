package A_Playground.Monad


//trait
//instances
//synntax


trait Monad[F[_]]{
  def pure[A](v:A):F[A]
  def flatMap[A,B](src:F[A])(fn:A=>F[B]):F[B]
  def map[A,B](src:F[A])(fn:A=>B):F[B]=flatMap(src)(x=>pure(fn(x)))
}

object Instances{
  type Id[A]=A

  val identityMonad:Monad[Id]=new Monad[Id] {
    override def pure[A](v: A): Id[A] = v
    override def flatMap[A, B](src: Id[A])(fn: A => Id[B]): Id[B] = fn(src)
  }

}