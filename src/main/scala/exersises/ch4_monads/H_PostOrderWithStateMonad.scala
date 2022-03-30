package co.uk.noreasonexception
package exersises.ch4_monads

import cats.Monad
import cats.data.State
import cats.implicits._
object H_PostOrderWithStateMonad{
  //  TODO Implement stack safety and invalid expression detection
  // Wow , State seems to be stack safe, maybe because is expressed as StateT[Eval,A,B]
  type PostOrderCalc = State[List[String],String]

  private def evalOne(str:String):PostOrderCalc=State[List[String],String](state=>{
    str.split(" ").toList match {
      case ::(head, next) if head=="+" => (state.tail.tail++(state.take(2).map(_.toInt).sum.toString::Nil),next.mkString(" "))
      case ::(head, next)=> (state++(head::Nil),next.mkString(" "))
      case Nil => (state,str)
    }
  })
  //Not Stack Safe
  private def chain[F[_]:Monad,A](n:Int,calc:A=>F[A],expr:A):F[A]={
    if(n>0)calc(expr).flatMap(newExpr=>chain(n-1,calc,newExpr))
    else calc(expr)
  }
  //Only Addition
  //Only works if expression has result, for example
  //1 2 + 3 + 6 + has result (12)
  //1 2 + 3 + 6   has result 6 and leftover state 6
  def evaluatePostOrder(expr:String):Int={
    chain(expr.split(" ").length,evalOne,expr)
      .run(Nil)
      .value._1.head.toInt
  }
  //using iterateWhileM
  def evaluate2(expression:String):Unit={
    val result = expression.iterateWhileM(evalOne)(_.nonEmpty)
    print(result.run(Nil).value)
  }

  def main(args:Array[String]):Unit={
    val expression = "1 2 + 3 + 6 +"
    println(evaluatePostOrder(expression))

    evaluatePostOrder((1 to 65000).mkString(" "))
  }


}