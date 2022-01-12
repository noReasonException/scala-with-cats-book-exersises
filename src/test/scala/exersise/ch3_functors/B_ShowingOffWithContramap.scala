package co.uk.noreasonexception
package exersise.ch3_functors

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
class B_ShowingOffWithContramap extends AnyFlatSpec with should.Matchers {

  "Contravariant Functor" should "work as expected" in {

    import co.uk.noreasonexception.exersises.ch3_functors.PrintableInstancesB._

    val strToInt: Double => Int = _.toInt
    val strIntInstanceToInt = instance[Int].contraMap(strToInt)
    val subject = 12.12
    val expected = 12

    strIntInstanceToInt.format(subject) shouldBe expected.toString
  }

}
