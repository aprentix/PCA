object ThreadsCreation extends App {
  class MyThread extends Thread {
    override def run(): Unit = {
      println(this.getName + " Esta ejecutandose")
    }
  }
  val t = new MyThread
  val a = new MyThread
  t.start()  // Start es para meter en la cola de prparados
  t.join()  // Join es para que cuando el proceso hijo muere, y vuelve a principal
  a.start()
  a.join()



}