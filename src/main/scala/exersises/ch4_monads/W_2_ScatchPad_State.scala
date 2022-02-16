package co.uk.noreasonexception
package exersises.ch4_monads

import cats.data.{State, Writer}
import cats.implicits.catsSyntaxApplicativeId
import cats.syntax.writer._

object W_2_ScatchPad_State {
  val plus_10_monad:State[Int,String] = State[Int, String]{ state =>
    (state+10, s"$state plus 10 equals ${state+10}")
  }
  val pow_2_monad:State[Int,String] = State[Int,String]{state=>
    (state*state,s"$state^2 equals ${state*state}")
  }
  val applicativeTest:State[Int,String]=State.pure("Hello world")






  def main(args:Array[String]):Unit={
    val result = (for{
      plus_10 <- plus_10_monad.run(230)
      pow_2 <- pow_2_monad.run(plus_10._1)
    }yield pow_2).value._1

    val result2 = for{
      a <- plus_10_monad
      b <- pow_2_monad
    }yield (a,b)

    println(result2.run(230).value)

    println(result)

  }



}
