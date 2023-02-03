import ExeActors801.{fe, fs}
import akka.actor._

import scala.io._
import java.io._

class PonBlancoActor (fe: String, out: ActorRef) extends Actor {
  def receive = PartialFunction.empty;
  val contenido = Source.fromFile(fe) // siendo fe el nombre de fichero
  var i = 1
  for (c <- contenido) {
    if(i%11==0){
      out!" "
    }
    else{
      out!c
    }
    i=i+1
  }
  contenido.close
}
object PonBlancoActor {
  def props(fe: String, out:ActorRef) = Props(new PonBlancoActor(fe, out))
}


class PonFlechaActor (out: ActorRef) extends Actor{
  var pendiente:Boolean = false;
  def receive={
   case "*" => {
     if(pendiente){
       out ! "^"
       pendiente = false
     }
   }
   case c => {
     if(pendiente){
       out ! "*"
       out ! c
       pendiente = false
     }
     else out ! c
   }
 }
}
object PonFlechaActor {
 def props(out: ActorRef) = Props(new PonFlechaActor(out))
}

 class PonCambioDeLineaActor (fs: String) extends Actor{
   val fo = new PrintWriter (new File(fs)) // fs es el nombre del fichero
   var i = 1
   def receive = {
     case _ =>{
       if(i%14==0){
         fo.write("\n"+_)
       }
       fo.write(""+_)
       i=i+1
     }
   };
   fo.close
 }
 object PonCambioDeLineaActor {
   def props(fs: String) = Props(new PonCambioDeLineaActor(fs))
 }


object ExeActors801 extends App {
  val fe = "in.txt"
  val fs = "out.txt"

  val ourSystem = ActorSystem("TransformaCaracteres")
  val pCL: ActorRef = ourSystem.actorOf(PonCambioDeLineaActor.props(fs))
  val pFL: ActorRef = ourSystem.actorOf (PonFlechaActor.props (pCL))
  val pBL: ActorRef = ourSystem.actorOf (PonBlancoActor.props (fe, pFL))

  Thread.sleep (5000)
  println ("FIN")
  ourSystem.terminate
}