package co.uk.noreasonexception
package exersises.ch4_monads

import cats.Monad
import cats.data.State
import cats.implicits._
object H_PostOrderWithStateMonadStackSafe{
  //  TODO Implement stack safety and invalid expression detection
  type PostOrderCalc = State[List[String],String]

  private def evalOne(str:String):PostOrderCalc=State[List[String],String](state=>{
    str.split(" ").toList match {
      case ::(head, next) if head=="+" => (state.tail.tail++(state.take(2).map(_.toInt).sum.toString::Nil),next.mkString(" "))
      case ::(head, next)=> (state++(head::Nil),next.mkString(" "))
      case Nil => (state,str)
    }
  })

  //Non Stack Safe, but closer to the definition of iterateWhileM
  def retry[F[_]:Monad,A](start:A)(f:A=>F[A])(cond:A=>Boolean):F[A]={
    if(cond(start))
      f(start).flatMap(a=>{
        retry(a)(f)(cond)
      })
    else f(start)
  }

  //iterateWhileM is stack safe -> depends on tailRecM
  def main(args:Array[String]):Unit={
    val expression = "1 2 + 3 + 6 +"
    val result = expression.iterateWhileM(evalOne)(_.nonEmpty)
    print(result.run(Nil).value)

  }


}