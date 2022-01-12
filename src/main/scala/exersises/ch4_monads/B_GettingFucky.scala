package co.uk.noreasonexception
package exersises.ch4_monads

import exersises.ch4_monads.common.Monad

import co.uk.noreasonexception.common.Box

object MonadInstancesA {
  implicit def monadBox: Monad[Box] = new Monad[Box] {
    override def pure[A](value: A): Box[A] = Box(value)

    override def flatMap[A, B](value: Box[A])(f: A => Box[B]): Box[B] = f(
      value.value
    )
  }
}

object A_GettingFucky {
  import MonadInstancesA._
  import co.uk.noreasonexception.exersises.ch4_monads.common.Monad._
  def main(args: Array[String]): Unit = {
    val box: Box[Int] = Box(12)
    print(box.flatMap(Box(_)))
  }
}
