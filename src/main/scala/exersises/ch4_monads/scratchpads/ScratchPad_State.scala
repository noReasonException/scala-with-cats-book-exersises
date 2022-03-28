package co.uk.noreasonexception
package exersises.ch4_monads.scratchpads

import cats.data.State

object ScratchPad_State {

  val x_plus_10:State[Int,Int]=State.apply(int=>{
    val result = int+10
    (result,result)
  })
  val x_pow_2:State[Int,Int]=State.apply(int=>{
    val result = int*int
    (result,result)
  })

  val plus_and_pow = for{
    plus <- x_plus_10
    //_ <- State.set(0)
    _ <- State.pure(12)
    pow <- x_pow_2
  }yield(pow)




  def main(args:Array[String]):Unit={
    println(plus_and_pow.runA(1).value)
  }
}
