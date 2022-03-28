package co.uk.noreasonexception
package exersises.ch4_monads.scratchpads

import cats.data.State

object ScratchPad_For_Comps {

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
    _ <- State.pure(12)
    pow <- x_pow_2
  }yield(pow)

  val plus_and_pow_2 =
    x_plus_10.flatMap(
      res => x_pow_2.map(
        res2 => res2
      )
    )
  val ru = plus_and_pow_2.runA(12)




  def main(args:Array[String]):Unit={
    println(plus_and_pow.runA(1).value)
  }
}
