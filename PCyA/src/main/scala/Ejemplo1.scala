object Ejemplo1 extends App{
  val v = Var("x")
  val op = BinOp("+", Number(1), v)
  println(v.name)
  println(op.left)
  println(op)
  abstract class Expr
  case class Var(name:String) extends Expr
  case class Number(num:Double) extends Expr
  case class UnOp (operator: String, arg:Expr) extends Expr
  case class BinOp (operator:String, left:Expr, right:Expr) extends Expr
}

//// NO FUNCIONA LA PARTE DE SCALA REPLY PG7
