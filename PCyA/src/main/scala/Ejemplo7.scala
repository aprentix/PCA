object Ejemplo7 extends App{
  def reordenaArray(a: Array[Int]): Array[Int] = {
    a.filter(_> 0)++a.filter(_<=0)
  }
  val c = Array (0, 1, 2, -3, -4)
  val res = reordenaArray(c)
  for(i<-res) println(i)
}
