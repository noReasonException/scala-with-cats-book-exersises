package C_2_4

import C_2_3.Monoid._
object AddMonoid{
  implicit def addMonoid=new Monoid[Set[Int]] {
    override def empty: Set[Int] = Set.empty

    override def combine(x: Set[Int], y: Set[Int]): Set[Int] = x ++ y
  }
}
//bored to do the rest of, but should be union,inter,diff

object MainC24A {
  import AddMonoid._
  def main(args: Array[String]): Unit = {
    val and=Monoid.apply[Set[Int]]
    print(and.combine((1::2::Nil).toSet,(2::3::Nil).toSet))
  }
}