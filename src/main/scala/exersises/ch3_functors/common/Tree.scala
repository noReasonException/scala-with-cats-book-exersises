package co.uk.noreasonexception
package exersises.ch3_functors.common

import cats.Functor

sealed trait Tree[+A]

case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A]

case class Leaf[+A](value: A) extends Tree[A]
