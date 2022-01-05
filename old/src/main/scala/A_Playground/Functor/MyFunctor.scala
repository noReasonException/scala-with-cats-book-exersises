package A_Playground.Functor

//trait
//instances
//syntax


trait Functor[F[_]]{
  def map[A,B](a:F[A])(fn:A=>B):F[B]
}
object Functor{
  type Fn1[A,B] = A=>B

  implicit val function0Instance = new Functor[Function0] {
    override def map[A, B](a: () => A)(fn: A => B): () => B = ()=> fn(a())
  }

}

object Ops{
  implicit class FunctOps[A,F[_]](a:F[A]){
    def map[B](fn:A=>B)(implicit instance:Functor[F]):F[B]={
      instance.map(a)(fn)
    }
  }
}
object MyFunctor {
  import Ops._
  import Functor._
  def main(args: Array[String]): Unit = {
    val a:() => Int = ()=>12
    val b:Int => Int = (a)=>13

    val fn = a map[Int] b
    print(fn())

  }
}
