package co.uk.noreasonexception
package exersise.ch4_monads

import common.Box

import co.uk.noreasonexception.exersises.ch4_monads.MonadInstancesC._
import org.scalatest.flatspec._
import org.scalatest.matchers._

class C_MonadicSecretIdentites extends AnyFlatSpec with should.Matchers {

  import co.uk.noreasonexception.exersises.ch4_monads.MonadInstancesA._
  import co.uk.noreasonexception.exersises.ch4_monads.common.Monad._

  "Id Monad" should "comply with right identity law" in {
    val id: Id[Int] = 12
    def identity[A](a: A): Id[A] = a
    id.flatMap(identity) shouldBe id
  }
  "Id Monad" should "comply with associativity law" in {
    val id: Id[Int] = 12
    val f: Int => Id[Int] = n => n + 10
    val g: Int => Id[Int] = n => n * 10
    id.flatMap(f).flatMap(g) shouldBe id.flatMap(a => f(a).flatMap(g))
  }
  "Id Monad" should "comply with left identity law" in {
    val id: Id[Int] = 12
    val f: Int => Id[Int] = n => n + 10

    id.flatMap(f) shouldBe f(12)
  }
}
