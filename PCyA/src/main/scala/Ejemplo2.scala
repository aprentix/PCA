object Ejemplo2 extends App{
  def obtenerSuma(args: Int *) : Int = {
    var suma : Int = 0
    for (num <- args) {
      suma += num
    }
    suma
  }
  def obtenerSumaFold(args: Int * ):Int = {
    args.fold(0)(_+_)
  }
  println ("Suma obtenida " + obtenerSuma(1,2,3,4,5,6))
}
