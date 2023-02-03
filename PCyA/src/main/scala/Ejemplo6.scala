object Ejemplo6 extends App{
  def eliminaNegativos(a: Array[Int]): Array[Int] = {
   for(i<-a if i>0) yield i
  }
  val b = Array(2,-1,3,4,-5)
  val res = eliminaNegativos(b)
}
