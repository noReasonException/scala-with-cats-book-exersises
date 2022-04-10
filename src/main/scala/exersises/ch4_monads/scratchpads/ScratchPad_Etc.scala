package co.uk.noreasonexception
package exersises.ch4_monads.scratchpads


import cats.Monad
import cats.syntax.monad._
import cats.syntax.applicative._
import cats.syntax.flatMap._
import cats.syntax.functor._
import cats.Id
import cats.instances.either
import cats.syntax.either._
object ScratchPad_Etc {



  def square[F[_]:Monad](one:F[Int],two:F[Int]):F[Int]=for{
    o<-one
    t<-two
  }yield o*o+t*t

  def main(args:Array[String]):Unit={
    val ok = square(1.asRight[String],2.asRight[String])
    val err = square(1.asRight[String],"Not Available Number".asLeft[Int])

    val ensured = ok.ensure("Sum of 2 squares is negative"){_<0}
    val recovered = err.getOrElse(1)
    val recoverCase1 = err.recover{
      case n:String if n=="Not Available Number" => 12
    }
    val recoverCase2 = err.recoverWith{
      case n:String if n=="Not Available Number" => 12.asRight[String]
    }

  }

}
