package C_4_7

import cats.Id
import cats.data.WriterT

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.global
import scala.language.postfixOps
import scala.concurrent.duration._
import cats.syntax.applicative._
import cats.syntax.writer._
/*
object Writer {
  def slowly[A](body: => A):A=
    try body finally Thread.sleep(100)
  object NonWriterMonadVersion {
    def factorial(n: Int): Int = {
      val ans = slowly(if (n == 0) 1 else n * factorial(n - 1))
      println(s"fact $n $ans")
      ans
    }
  }
  object WriterMonadVersion{
    type LoggedResult[A]=WriterT[Id,Vector[String],A]
    def factorial(n:Int):LoggedResult[Int]={
      val ans:LoggedResult[Int]=slowly(if (n==0) 1.pure[LoggedResult]else n * factorial(n - 1).value)
      ans.value.writer(Vector(s"fact $n $ans"))
    }
  }

  def main(args: Array[String]): Unit = {
    implicit val ec=scala.concurrent.ExecutionContext.global
    val v = Vector(
      Future(WriterMonadVersion.factorial(3)),
      Future(WriterMonadVersion.factorial(6)),
      Future(WriterMonadVersion.factorial(9)),
      Future(WriterMonadVersion.factorial(12))
    )
    v.foreach(Await.result(_,5 seconds))
  }
}
*/