package co.uk.noreasonexception
package exersise.ch3_functors

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
import co.uk.noreasonexception.exersises.ch3_functors.Box
class C_ShowingOffWithContramapPt2 extends AnyFlatSpec with should.Matchers {

  "Contravariant Functor" should "work as expected" in {

    import co.uk.noreasonexception.exersises.ch3_functors.Printable2._

    val strToInt: Double => Int = _.toInt
    val strIntInstanceToInt = instance[Int].contraMap(strToInt)
    val subject = 12.12
    val expected = 12

    strIntInstanceToInt.format(subject) shouldBe expected.toString
  }
  "Box value class functor" should "work as expected" in {

    import co.uk.noreasonexception.exersises.ch3_functors.Printable2._

    val subject = Box(12)
    val expected = 12

    subject.format shouldBe expected.toString
  }

}
