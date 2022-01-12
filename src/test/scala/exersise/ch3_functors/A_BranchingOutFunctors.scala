package co.uk.noreasonexception
package exersise.ch3_functors

import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
import co.uk.noreasonexception.exersises.ch3_functors.common._
import co.uk.noreasonexception.exersises.ch3_functors.TreeInstancesA._
class A_BranchingOutFunctors extends AnyFlatSpec with should.Matchers {

  "TreeFunction" should "obey identity Law" in {

    val tree: Tree[Int] =
      Branch(Leaf(1), Branch(Branch(Leaf(2), Leaf(3)), Leaf(4)))
    def id[A]: A => A = a => a
    tree.map(id) shouldBe tree
  }
  "TreeFunction" should "obey composition Law" in {

    val tree: Tree[Int] =
      Branch(Leaf(1), Branch(Branch(Leaf(2), Leaf(3)), Leaf(4)))
    def f(x: Int): Int = x + 1
    def g(x: Int): Int = x - 1
    tree.map(f).map(g) shouldBe tree.map(x => g(f(x)))
  }

}
