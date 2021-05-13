package C_2_3

import C_2_3.Monoid._
object AndMonoid{
  implicit def andMonoid=new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x&&y
  }
}
object OrMonoid{
  implicit def orMonoid=new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x||y
  }
}

object MainC23A {
  import OrMonoid._
  import AndMonoid._
  def main(args: Array[String]): Unit = {
    val andMon = AndMonoid.andMonoid
    val orMon = OrMonoid.orMonoid
    val or=Monoid.apply[Boolean](orMon)
    val and=Monoid.apply[Boolean](andMon)
    print(or.combine(true,false))
    print(and.combine(true,false))
  }
}