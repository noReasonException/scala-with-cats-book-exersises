package co.uk.noreasonexception
package exersise.ch4_monads

import co.uk.noreasonexception.exersises.ch4_monads.Db
import org.scalatest.flatspec._
import org.scalatest.matchers._
import cats.implicits._
class G_ReaderMonad extends AnyFlatSpec with should.Matchers {
  import co.uk.noreasonexception.exersises.ch4_monads.Login._
  val db:Db=Db(
    Map(
      (1->"John"),
      (2->"Mary")
    ),
    Map(
      ("John"->"password123"),
      ("Mary"->"mydognameislucy")
    )
  )
  "Login reader monad" should "return username that exists" in {
      findUsername(1).run(db) shouldBe "John".some
  }
  "Login reader monad" should "not return username that dont exist" in {
    findUsername(42).run(db) shouldBe none
  }
  "Login reader monad" should "verify user's correct password" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkPassword("John","password123").run(db) shouldBe true.some
  }
  "Login reader monad" should "verify user's incorrect password" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkPassword("John","incorrect-password").run(db) shouldBe false.some
  }
  "Login reader monad" should "not found non-existent user's password" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkPassword("Kevin","kevinspassword").run(db) shouldBe none
  }
  "Login reader monad" should "check full login sequence" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkLogin(1,"password123").run(db) shouldBe true
  }
  "Login reader monad" should "deny non-existent user full login sequence" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkLogin(12,"password123").run(db) shouldBe false
  }
  "Login reader monad" should "deny incorrest user password full login sequence" in {
    import co.uk.noreasonexception.exersises.ch4_monads.Login._
    checkLogin(1,"incorrect-password").run(db) shouldBe false
  }
}
