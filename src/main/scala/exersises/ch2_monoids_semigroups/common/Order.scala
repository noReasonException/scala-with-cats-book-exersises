package co.uk.noreasonexception
package exersises.ch2_monoids_semigroups.common

import cats.{Monoid, Semigroup}

case class Order(totalCost: Double, quantity: Double)

object Order {
  private def combineOrder: (Order, Order) => Order = (first, second) =>
    Order(first.totalCost + second.totalCost, first.quantity + second.quantity)
  implicit val semigroupOrder: cats.Semigroup[Order] =
    Semigroup.instance(combineOrder)
  implicit val monoidOrder: cats.Monoid[Order] =
    Monoid.instance(Order(0, 0), combineOrder)
}
