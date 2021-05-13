import A_Playground.PlayMain
import C_1_3.{MainC13A, MainC13B}
import C_1_4.{MainC14A, MainC14B}
import C_1_5.MainC15A
import C_2_3.MainC23A
import C_2_4.MainC24A
import C_2_5.MainC25A
import cats.Show
import cats.instances.int._
import cats.syntax.show._
import cats.Eq
import cats.instances.option._
import cats.syntax.eq._
object Main {
  val PLAY=PlayMain
  //chapter 1.3
  val EXERSISE_C_1_3_1=MainC13A
  val EXERSISE_C_1_3_2=MainC13B
  //chapter 1.4
  val EXERSISE_C_1_4_1=MainC14A
  val EXERSISE_C_1_4_2=MainC14B
  //chapter 1.5
  val EXERSISE_C_1_5_1=MainC15A

  //chapter 2
  val EXERSISE_C_2_3_1=MainC23A
  val EXERSISE_C_2_3_2=MainC24A
  val EXERSISE_C_2_5_1=MainC25A
  val selector=EXERSISE_C_2_5_1
  def main(args: Array[String]): Unit = {
    selector.main(args)

  }

}
