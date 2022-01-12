package co.uk.noreasonexception
package exersise.ch3_functors

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
class D_TransformativeThinkingWithImap
    extends AnyFlatSpec
    with should.Matchers {

  "Invariant Functor" should "work as expected" in {
    import co.uk.noreasonexception.exersises.ch3_functors.CodecInstancesE._

    decode[Int]("12") + 12 shouldBe 24
  }
}
