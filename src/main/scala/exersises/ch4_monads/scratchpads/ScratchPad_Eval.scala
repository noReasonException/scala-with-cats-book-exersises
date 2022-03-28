package co.uk.noreasonexception
package exersises.ch4_monads.scratchpads

import cats.data.Writer
import cats.implicits._
object ScratchPad_Eval {
  type LoggedResult[A] = Writer[Vector[String], A]

  def main(args: Array[String]): Unit = {
    val b = Vector("only").tell
    val c = 123.pure[LoggedResult]

    //evaluation strategy
    //        strict binding techiques(eveything evalueated before function invocation)
    //call by value
    //call by reference
    //call by sharing (reference, but for objects)
    //call by copy-restore
    //        non-strict techniques
    //call by need (lazy but memoized)
    //call by name (lazy but not memoized)
    //Call by macro expansion
    //Call by future
    //Optimistic evaluation

    def one[A, B](a: A): Int = 12 //call by value

    def two[A, B](a: => A): Int = 12 //call by name

    def three[A, B](a: () => A): Int = 12 //call by value(copying function body)

    //    print{
    //      for{
    //        first <- Vector("only").tell.map(_=>0)
    //        second <- 123.pure[LoggedResult]
    //      }yield first+second
    //    }
    //    println()
    //    print{
    //      for{
    //        first <- Writer(Vector("msg1"),100)
    //        second <- Writer(Vector("msg2"),200)
    //      }yield(first+second)
    //    }
    //  }
  }
}
