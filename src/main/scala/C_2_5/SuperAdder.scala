package C_2_5
import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import cats.syntax.monoid._
object SuperAdderV1 {
  def add(list:List[Int]):Int=list.fold(0)(_|+|_)
  def addOpt(list: List[Option[Int]]):Int=add(list.collect{case Some(x)=>x})
}
object SuperAdderV2 {
  def add[A](list:List[A])(implicit monoid: Monoid[A]):A=list.fold(Monoid.empty[A])(_|+|_)
}
case class Order(totalCost: Double, quantity: Double)
object Order{
  implicit val orderMonoid:Monoid[Order]=new Monoid[Order]{
    override def empty: Order = Order(0,0)
    override def combine(x: Order, y: Order): Order = Order(x.totalCost+y.totalCost,x.quantity+y.quantity)
  }
}
object MainC25A{
  import SuperAdderV2._
  def main(args: Array[String]): Unit = {
    println(add(List.range(1,10).map(n=>Order.apply(n,n))))
  }
}
