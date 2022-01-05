package C_1_3

case class Cat(name:String,age:Int,color:String)

object Cat{
  implicit def catPrintable(implicit strPrintable:Printable[String],intPrintable:Printable[Int]):Printable[Cat]=new Printable[Cat] {
    override def format(a: Cat): String =
      strPrintable.format(a.name)+" is an "+intPrintable.format(a.age)+" year old "+strPrintable.format(a.color)+" cat"
  }
}
object MainC13B{
  import Printable._
  import PrintableLibraryInstances._
  def main(args: Array[String]): Unit = {
    Cat("zuko",1,"black-white").pprint
  }
}