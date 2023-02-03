
import de._
object ThreadsNondeterminism extends App {
  val t = thread { log("New thread running.") }
  /// No deterministico
  /// Crea un thread y dos funciones, las intercala y por ello el ordne de salida es no determinista
  log("...")
  log("...")
  t.join()
  log("New thread joined.")
  /// unicamente esta el main
}
