import de._
object ParallelBlock extends App {
  def parallel(a: ()=>Int, b: ()=>Int): (Int, Int) = {
    //var resultA: A = 1.asInstanceOf[A]
    //var resultB: B = 1.asInstanceOf[B]
    var resultA:Int = 0
    var resultB:Int = 0

    val threadA = thread {
      log("ThreadA")
      resultA = a()
    }
    val threadB = thread {
      log("ThreadB")
      resultB = b()
    }
    threadA.join()
    threadB.join()
    (resultA, resultB)
    /// Si no ponemos los join, los procesos no acaban y devuelve el resultado inicialmente asignado

  }
  val task1 :() => Int = () => {println("Empieza el calculo 1: "); 3+4}:Int
  val task2 = () => {println("Empieza el calculo 2: "); 3*1}

  println (parallel (task1, task2))
  log ("FIN")
}