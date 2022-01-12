package co.uk.noreasonexception
package exersise.ch4_monads

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
import co.uk.noreasonexception.common.Box
class B_GettingFucky extends AnyFlatSpec with should.Matchers {

  import co.uk.noreasonexception.exersises.ch4_monads.MonadInstancesA._
  import co.uk.noreasonexception.exersises.ch4_monads.common.Monad._

  "Box Monad" should "comply with right identity law" in {
    val box = Box(12)
    def identity[A](a: A): Box[A] = Box(a)
    box.flatMap(identity) shouldBe box
  }
  "Box Monad" should "comply with associativity law" in {
    val box = Box(12)
    val f: Int => Box[Int] = n => Box(n + 10)
    val g: Int => Box[Int] = n => Box(n * 10)
    box.flatMap(f).flatMap(g) shouldBe box.flatMap(a => f(a).flatMap(g))
  }
  "Box Monad" should "comply with left identity law" in {
    val box = Box(12)
    val f: Int => Box[Int] = n => Box(n + 10)
    pure(12).flatMap(f) shouldBe f(12)
  }
}
