object Ejercicio8 extends App{
  def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    val a = values.filter(_>v).length
    val b = values.filter(_==v).length
    val c = values.filter(_<v).length
    (a,b,c)
  }
  val valores = Array (2, -1, 3, 4, -5)
  val valor = 3
  val res = lteqgt(valores, valor)
  println (res.toString)
}
