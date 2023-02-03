object filterList extends App{
  def filterOdd(inLst: List[Int]):List[Int] = {
    for(i <- inLst if i%2!=0) yield i
  }
  def filterEven(inLst: List[Int]):List[Int] = {
    for(i <- inLst if i%2==0) yield i
  }
  def filter(uno: List[Int], f:(Int)=>Boolean):List[Int]={
    for(e <- uno if e%2==0) yield e
  }

  def filterGeneric[T](uno: List[T], f:(T)=>Boolean):List[T]={
    for(e <- uno if f(e)) yield e
  }

  var isOdd = (num:Int) => {num%2!=0}: Boolean
  var isOdd2 : (Int) => Boolean = (v:Int) => {(v%2)==1}:Boolean

  var lst = List(1,7,2,8,5,6,3,9,14,12,4,10)
  var lstd = List(1.5, 7.3, 8.2)
  var lsts = List("kjhf", "lskdfj", "aljd")
  println(filterGeneric(lstd,isOdd))
  println(filterGeneric(lsts, (v:String) => v.length>3))
  println(filterGeneric(lsts, (v:Double) => v>3))

  val a = List(6,32,3,9,4)
  println(filterGeneric(a,isOdd))
  val b = filterOdd(a)
  val c = filterEven(a)
  var OddList = filter(a, isOdd)
}
