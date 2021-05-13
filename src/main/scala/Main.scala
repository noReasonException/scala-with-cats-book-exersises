import C_1_3.{FakeMainC13A, FakeMainC13B}
import C_1_4.{FakeMainC14A, FakeMainC14B}
import C_1_5.FakeMainC15A
import cats.Show
import cats.instances.int._
import cats.syntax.show._
import cats.Eq
import cats.instances.option._
import cats.syntax.eq._
object Main {
  //chapter 1.3
  val EXERSISE_C_1_3_1=FakeMainC13A
  val EXERSISE_C_1_3_2=FakeMainC13B
  //chapter 1.4
  val EXERSISE_C_1_4_1=FakeMainC14A
  val EXERSISE_C_1_4_2=FakeMainC14B

  val EXERSISE_C_1_5_1=FakeMainC15A
  val selector=EXERSISE_C_1_4_2
  def main(args: Array[String]): Unit = {
    selector.main(args)

  }

}
