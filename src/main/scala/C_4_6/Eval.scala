package C_4_6

import cats.Eval


object Factorials{
  def factorialV1(n:BigInt):BigInt={
    if(n==1)1
    else factorialV1(n-1)*n
  }
  def factorialV2(n:BigInt):Eval[BigInt]={
    if(n==1)Eval.now(1)
    else factorialV2(n-1).map(_*2)
  }
  def factorialV3(n:BigInt):Eval[BigInt]={
    if(n==1)Eval.now(1)
    else Eval.defer(factorialV3(n-1).map(_*2))
  }
  def foldRight[A,B](as:List[A],acc:B)(fn:(A,B)=>B):B={
    as match {
      case ::(head, next) => foldRight(next,fn(head,acc))(fn)
      case Nil =>acc
    }
  }
  def foldRightSafe[A,B](as:List[A],acc:B)(fn:(A,B)=>B):B={
    def _foldRightSafe[A,B](as:List[A],acc:B)(fn:(A,B)=>B):Eval[B]={
      as match {
        case ::(head, next) => Eval.defer(_foldRightSafe(next,fn(head,acc))(fn))
        case Nil =>Eval.now(acc)
      }
    }
    _foldRightSafe(as,acc)(fn).value
  }
  def main(args: Array[String]): Unit = {
    val test = (1 to 20000).toList
    print(foldRightSafe(test,BigInt(0))((a,b)=>a+b))
  }
}