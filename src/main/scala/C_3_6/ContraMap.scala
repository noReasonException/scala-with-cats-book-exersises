package C_3_6

import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import cats.syntax.monoid._


sealed trait Printable[A]{
  def format(a:A):String
  def contramap[B](fn:B=>A):Printable[B] = {
    def closure(p:Printable[A]):Printable[B]=
      new Printable[B] {
        override def format(a: B): String = p.format(fn(a))
      }
    closure(this)
  }
}

object Printable{
  implicit val printableIntegerInstance=new Printable[Int] {
    override def format(a: Int): String = a.toString
  }

}

object MainC36A{
  def s(v:String):Int=v.toInt
  def main(args: Array[String]): Unit = {
    import Printable._
    val a = Printable.printableIntegerInstance

    val contra=a.contramap(s)
  }
}