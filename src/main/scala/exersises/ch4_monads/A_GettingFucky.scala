package co.uk.noreasonexception
package exersises.ch4_monads

import exersises.ch4_monads.common.Box

object A_GettingFucky {
  import co.uk.noreasonexception.exersises.ch4_monads.common.MonadInstances._
  import co.uk.noreasonexception.exersises.ch4_monads.common.Monad._
  def main(args: Array[String]): Unit = {
    val box: Box[Int] = Box(12)
    print(box.flatMap(Box(_)))
  }
}
