import Logic._

object Logic extends Implicits1 {
  case class ==>[P, C](show: String)

  trait Not[A]
  
  trait And[A, B]
  
  trait Or[A, B]
}

trait Implicits1 extends Implicits2 {
  implicit def deMorgansLaw[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) =
    ==>("deMorgansLaw")
}

trait Implicits2 extends Implicits3 {
  implicit def doubleNegationElimination[A]: Not[Not[A]] ==> A =
    ==>("doubleNegationElimination")

  implicit def modusTollens[A, B](implicit p1: A ==> B): Not[B] ==> Not[A] =
    ==>(s"modusTollens(${p1.show})")
}

trait Implicits3 {
  implicit def chainRule[A, B, C](implicit p1: A ==> B, p2: B ==> C): A ==> C =
    ==>(s"chainRule(${p1.show}, ${p2.show})")
}

object Test extends App {
  def deMorgansLawSubst1[A, B]: Not[Not[A] Or Not[B]] ==> (A And B) =
    chainRule(modusTollens(deMorgansLaw), doubleNegationElimination)

  def deMorgansLawSubst2[A, B]: Not[Not[A] Or Not[B]] ==> (A And B) =
    implicitly[Not[Not[A] Or Not[B]] ==> (A And B)]

  println(deMorgansLawSubst2.show)
  // prints: chainRule(modusTollens(deMorgansLaw), doubleNegationElimination)
}
