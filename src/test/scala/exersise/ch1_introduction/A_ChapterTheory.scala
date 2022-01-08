package co.uk.noreasonexception
package exersise.ch1_introduction

import co.uk.noreasonexception.exersises.ch1_introduction.{
  JsNull,
  JsString,
  Json,
  JsonWriterInstances
}
import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers._

import scala.collection.mutable.Stack

class A_ChapterTheory extends AnyFlatSpec with should.Matchers {

  import JsonWriterInstances._
  import Json._
  "A string" should "be able to be converted to a JsString using extension methods" in {
    "hello-world".asJson shouldBe JsString("hello-world")
  }
  "A None:Option[T]" should "be able to be converted to JsNull given an JsonWriter[T] in implicit scope" in {
    val maybe: Option[String] = None
    maybe.asJson shouldBe JsNull
  }
  "A Some(\"hello-world\"):Option[T]" should "be able to be converted to JsString given an JsonWriter[T] in implicit scope" in {
    val maybe: Option[String] = Some("hello-world")
    maybe.asJson shouldBe JsString("hello-world")
  }
}
