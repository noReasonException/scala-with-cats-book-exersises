package A_Playground.ContraMap

//trait
//instance
//syntax

trait ContraMapAble[F[_]]{
  def contraMap[A,B](src:F[B])(fn:A=>B):F[A]
}

trait Printable[A]{
  def format(element:A):String
}


object Instances{
  /***
   * I cannot define globally the contraMap, because i need more information about the underlying operation
   * of a F[A-B]
   */
  implicit val printableContraMap:ContraMapAble[Printable]=new ContraMapAble[Printable] {
    override def contraMap[A, B](src: Printable[B])(fn: A => B): Printable[A] = new Printable[A] {
      override def format(element: A): String = src.format(fn(element))
    }
  }


  implicit val printableStr:Printable[String]=new Printable[String] {
    override def format(element: String): String = element
  }
}

/**
 * I can however, provide a global definition of the syntax
 */
object SyntaxOps{
  implicit class ContraMapSyntaxOps[F[_],B](element:F[B]){
    def contraMap[A](fn:A=>B)(implicit contra:ContraMapAble[F]):F[A]=contra.contraMap(element)(fn)
  }
}

object ContraMap{
  import SyntaxOps._
  import Instances._
  def intToStr(int:Int):String=int.toString
  def main(args: Array[String]): Unit = {
    val a = printableStr

    val b = a.contraMap(intToStr)

    print(b.format(12))
  }
}
