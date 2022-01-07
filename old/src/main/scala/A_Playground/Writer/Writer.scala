package A_Playground.Writer
import cats.data.Writer
import cats.instances.vector._ //for monoid, we need the empty Vector
import cats.syntax.applicative._ //for pure
import cats.syntax.writer._
object WriterExample {
  type Logged[A] = Writer[Vector[String], A]
  val intSquared: Int => Int = a => a * a

  def main(args: Array[String]): Unit = {
    val (logs, result) = intSquared.apply(12).pure[Logged].run
    val (logs2, result2) = Vector("Failed").tell.run
    print(logs)

  }
}
