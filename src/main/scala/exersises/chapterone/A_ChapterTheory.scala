package co.uk.noreasonexception
package exersises.chapterone

/** Type class contain The trait itself Implementations of the trait, implicit
  * Implicit parameters of those implementations Extension methods, implicit
  */
//Helper ADT
sealed trait Json
case class JsString(str: String) extends Json
case class JsInt(int: Int) extends Json
case class JsArray[T](arr: Array[T]) extends Json
case class JsObject(obj: Json) extends Json
case object JsNull extends Json
//The trait
trait JsonWriter[T] {
  def write(str: T): Json
}
//The Implementations
object JsonWriterInstances {
  //Implementations
  implicit val jsonWriterStringInstance: JsonWriter[String] = {
    new JsonWriter[String] {
      override def write(str: String): Json = JsString(str)
    }
  }
  //Using Recursive implicit resolution to write an implementation of Option[T<:Any] given
  // a JsonWriter[T]
  implicit def jsonWriterOptionInstance[T](implicit
      jw: JsonWriter[T]
  ): JsonWriter[Option[T]] = {
    new JsonWriter[Option[T]] {
      override def write(str: Option[T]): Json = str match {
        case Some(value) => jw.write(value)
        case None => JsNull
      }
    }
  }

}
//Helpers
//This is a generic helper, selects always the appropriate T, a more simplified yet problematic implenentation would be
//Interface Syntax
object Json {
  //Good, Generic Implementation
  implicit class JsonOps[T](any: T) {
    def asJson(implicit jsonWriter: JsonWriter[T]): Json =
      jsonWriter.write(any)
  }
  //Simpler, but bad, because for every JsonWriterInstance implementation we will need a different Ops
//  implicit class StrJsonOps(str:String){
//    def asJson(implicit jsonWriter: JsonWriter[String]):Json=
//      jsonWriter.write(str)
//  }

}
//Interface Object
object Json2 {
  def asJson[T](t: T)(implicit jsonWriter: JsonWriter[T]): Json =
    jsonWriter.write(t)
}

object Main {
  import JsonWriterInstances._
  import Json._
  def main(args: Array[String]): Unit = {
    val interfaceSyntax = "hello-world".asJson
    val interfaceObjects = Json2.asJson[String]("hello-world")
    print(interfaceSyntax)
    print(interfaceObjects)
  }
}
