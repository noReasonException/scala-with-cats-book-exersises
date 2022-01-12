package co.uk.noreasonexception
package exersise.ch3_functors

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
import co.uk.noreasonexception.exersises.ch3_functors.BoxE
class E_TransformativeThinkingWithImapPt2
    extends AnyFlatSpec
    with should.Matchers {

  "Invariant Functor" should "work as expected" in {
    import co.uk.noreasonexception.exersises.ch3_functors.CodecInstancesE._

    decode[Int]("12") + 12 shouldBe 24
  }
  "Box Invariant Functor" should "work as expected" in {
    import co.uk.noreasonexception.exersises.ch3_functors.CodecInstancesE._

    encode[BoxE[Int]](BoxE(12)) shouldBe "12"
    decode[BoxE[Int]]("12") shouldBe BoxE[Int](12)

  }
}
