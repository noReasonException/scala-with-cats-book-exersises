import C_1_3.{FakeMainC13A, FakeMainC13B}
import C_1_4.{FakeMainC14A, FakeMainC14B}
import cats.Show
import cats.instances.int._
import cats.syntax.show._
object Main {
  val EXERSISE_C_1_3_1=FakeMainC13A
  val EXERSISE_C_1_3_2=FakeMainC13B

  val EXERSISE_C_1_4_1=FakeMainC14A
  val EXERSISE_C_1_4_2=FakeMainC14B

  val selector=EXERSISE_C_1_4_2
  def main(args: Array[String]): Unit = {
    selector.main(args)
  }

}
