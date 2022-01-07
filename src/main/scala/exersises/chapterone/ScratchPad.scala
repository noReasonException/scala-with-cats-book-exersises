package co.uk.noreasonexception
package exersises.chapterone

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
    def format(a: A): String

  }

  def format[A](a: A)(implicit jw: JsonWriter[A]): String = {
    jw.format(a)
  }

  implicit val squareWriter: JsonWriter[Square] = new JsonWriter[Square] {
    override def format(a: Square): String = "SQUARE"
  }

  implicit val shapeWriter: JsonWriter[Shape] = new JsonWriter[Shape] {
    override def format(a: Shape): String = "SHAPE"
  }

  def main(args: Array[String]): Unit = {
    val sq: Square = Square()
    val sh: Shape = new Shape()

    format(sq)(squareWriter)
  }

}
