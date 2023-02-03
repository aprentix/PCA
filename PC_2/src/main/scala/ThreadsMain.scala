object ThreadsMain extends App{
  val t: Thread = Thread.currentThread()
  val name = t.getName
  println(s"I am the thread $name")
  Thread.sleep(1000)
  println(s"I am the thread $name")
  println(s"I am the thread $name")
}
