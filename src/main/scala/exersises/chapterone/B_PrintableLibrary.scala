package co.uk.noreasonexception
package exersises.chapterone

trait Printable[A]{
  def format(obj:A):String
}
object PrintableInstances{
  implicit val printableInstanceForInt={
    new Printable[Int] {
      def format(obj:Int):String=obj.toString
    }
  }
  implicit val printableInstanceForStr={
    new Printable[String] {
      def format(obj:String):String=obj
    }
  }
  implicit def printableInstanceForCat(implicit intPrintable:Printable[Int],strPrintable:Printable[String])={
    new Printable[Cat] {
      override def format(obj: Cat): String =
        strPrintable.format(obj.name)+" is a "+
          intPrintable.format(obj.age)+" year-old "+
          strPrintable.format(obj.color)+" cat"
    }
  }

}
object Printable{
  implicit class PrintableOps[A](obj:A) {
    def format(implicit printableInstance:Printable[A])=printableInstance.format(obj)
    def consolePrint(implicit printableInstance:Printable[A])=print(format)
  }

}
//Application
case class Cat(name:String,age:Int,color:String)

object B_PrintableLibrary{
  import PrintableInstances._
  import Printable._
  def main(args: Array[String]): Unit = {
    val cat = Cat("Zuko",1,"Black and white")
    print(cat.format)
  }

}
