package C_1_3

trait Printable[A]{
  def format(a:A):String
}


object PrintableLibraryInstances{
  implicit val strPrintable=new Printable[String] {
    override def format(a: String): String = a
  }
  implicit val intPrintable=new Printable[Int] {
    override def format(a: Int): String = a.toString
  }
}

object Printable{

  implicit  class PrintableOps[A](a:A){
    def pformat(implicit printable:Printable[A]):String=printable.format(a)
    def pprint(implicit printable:Printable[A]):Unit=println(this.pformat)
  }
}


object FakeMainC13A {
  import Printable._
  import PrintableLibraryInstances._
  def main(args: Array[String]): Unit = {
    println("he".pformat)
    println(12.pformat)
  }
}