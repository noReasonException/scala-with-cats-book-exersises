package co.uk.noreasonexception
package exersises.ch4_monads

import cats.data.Reader
import cats.implicits._

final case class Db(
  users:Map[Int,String],
  passwords:Map[String,String]
)

object Login{
  type DbReader[A] = Reader[Db,A]
  def findUsername(userId:Int):DbReader[Option[String]] =
    Reader(db=>db.users.get(userId))

  def checkPassword(username:String,password:String):DbReader[Option[Boolean]] =
    Reader(db=>db.passwords.get(username).map(_==password))

  def checkLogin(userId:Int,password:String):DbReader[Boolean]={
    (for{
      maybeUsername <- findUsername(userId)
      passwordCheck <- maybeUsername match {
        case Some(username) => checkPassword(username,password)
                                .map(_.getOrElse(false))
        case None => false.pure[DbReader]
      }
    }yield passwordCheck)
  }
}
object G_ReaderMonad {
  def main(args:Array[String]):Unit={

  }
}
