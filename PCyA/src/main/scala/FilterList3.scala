object FilterList3 extends App{
  val isOdd = (v:Int) => v%2==1
  val isEven = (v:Int) => v%2==0
  var sum : (Int, Int) => Boolean = (x:Int, y:Int) => x+y==0
  var sum2 = (x: Int, y: Int) => (x+y)%2==0: Boolean
}
