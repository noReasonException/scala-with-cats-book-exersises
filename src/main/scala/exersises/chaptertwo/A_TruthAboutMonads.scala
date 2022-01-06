package co.uk.noreasonexception
package exersises.chaptertwo

import exersises.chaptertwo.common.Monoid

object MonoidAnd{
  implicit val andMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(first: Boolean, second: Boolean): Boolean = first&&second
  }
}
object MonoidOr{
  implicit val orMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(first: Boolean, second: Boolean): Boolean = first||second
  }
}
object MonoidXor{
  implicit val xorMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(first: Boolean, second: Boolean): Boolean = first^second
  }
}
object MonoidXNor{
  implicit val xorMonoid:Monoid[Boolean]=new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(first: Boolean, second: Boolean): Boolean = !(first^second)
  }
}




object A_TruthAboutMonads {
  import Monoid._
  import MonoidAnd._

  def main(args: Array[String]): Unit = {
    print(true.combine(false).combine(empty))
  }

}
