package co.uk.noreasonexception
package exersises.ch4_monads

import exersises.ch4_monads.common.Monad

import co.uk.noreasonexception.common.Box

object MonadInstancesC {
  type Id[A] = A
  implicit def monadId: Monad[Id] = new Monad[Id] {
    override def pure[A](value: A): Id[A] = value

    //The final punch line is that, once we strip away the Id type constructors,
    //flatMap and map are actually identical:
    //This ties in with our understanding of functors and monads as sequencing type
    //classes. Each type class allows us to sequence operations ignoring some kind
    //of complication. In the case of Id there is no complication, making map and
    //flatMap the same thing
    override def flatMap[A, B](value: Id[A])(f: A => Id[B]): Id[B] = f(value)

    override def map[A, B](value: Id[A])(f: A => B): Id[B] = f(value)
  }
}

object C_MonadicSecretIdentities {
  import MonadInstancesA._
  import co.uk.noreasonexception.exersises.ch4_monads.common.Monad._
  def main(args: Array[String]): Unit = {}
}
