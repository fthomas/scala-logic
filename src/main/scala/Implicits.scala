import Logic._

trait Implicits0 extends Implicits1 {
  implicit def modusTollens[A, B](implicit p1: A ==> B): Not[B] ==> Not[A] = ==>(s"modusTollens(${p1.show})")
}

trait Implicits1 extends Implicits2 {
  implicit def deMorgansLaw1[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) = ==>("deMorgansLaw1")
}

trait Implicits2 extends Implicits3 {
  implicit def deMorgansLaw2[A, B]: Not[A Or B] ==> (Not[A] And Not[B]) = ==>("deMorgansLaw2")
}

trait Implicits3 extends Implicits4 {
  implicit def doubleNegationElimination[A]: Not[Not[A]] ==> A = ==>("doubleNegationElimination")
}

trait Implicits4 {
  implicit def chainRule[A, B, C](implicit p1: A ==> B, p2: B ==> C): A ==> C = ==>(s"chainRule(${p1.show}, ${p2.show})")
}