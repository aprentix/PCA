object Ejemplo5 extends App{
  def potencia(x: Double, n: Int): Double = {
    n match {
      case 0 => 1
      case n: Int  if(n<0) => n-1
    }
  }
  println("4 elevado a -1: ", potencia(4,-1))
  println("4 elevado a 0: ", potencia(4,0))
}
