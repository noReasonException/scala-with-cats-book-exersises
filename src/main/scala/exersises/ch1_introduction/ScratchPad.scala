package co.uk.noreasonexception
package exersises.ch1_introduction

object ScratchPad {

  class Shape()
  case class Square() extends Shape

  /** Αν Parent<-Child1<-Child2 τοτε αν σου γυρισω F[Child1] μπορεις να το
    * ερμηνευσεις ως F[Parent] Αν ομως Parent<-Child1<-Child2 τοτε, αν δεχομαι
    * F[Child1] δεν μπορεις αν μου δωσεις F[Parent] ! μπορεις Να μου δωσεις ειτε
    * Child1 είτε Child2
    * @tparam A
    */

  trait JsonWriter[-A] {
    def format(any: A): String

  }

  def format[A](any: A)(implicit jw: JsonWriter[A]): String = {
    jw.format(any)
  }

  implicit val squareWriter: JsonWriter[Square] = new JsonWriter[Square] {
    override def format(square: Square): String = "SQUARE"
  }

  implicit val shapeWriter: JsonWriter[Shape] = new JsonWriter[Shape] {
    override def format(shape: Shape): String = "SHAPE"
  }

  def main(args: Array[String]): Unit = {
    val square: Square = Square()
    val shape: Shape = new Shape()

    format(square)(squareWriter)
  }

}
