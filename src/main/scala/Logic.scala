object Logic extends Implicits0 {

  case class ==>[P, C](show: String)

  trait Not[A]

  trait And[A, B]
  
  trait Or[A, B]
}
