import Logic._

object Template {
  implicit def conjunctionCommutativity[A, B]: (A And B) ==> (B And A) = ==>("conjunctionCommutativity")
  implicit def modusTollens[A, B](implicit p1: A ==> B): Not[B] ==> Not[A] = ==>(s"modusTollens(${p1.show})")
  implicit def deMorgansLaw2[A, B]: Not[A Or B] ==> (Not[A] And Not[B]) = ==>("deMorgansLaw2")
  implicit def deMorgansLaw1[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) = ==>("deMorgansLaw1")
  implicit def doubleNegationElimination[A]: Not[Not[A]] ==> A = ==>("doubleNegationElimination")
  implicit def chainRule[A, B, C](implicit p1: A ==> B, p2: B ==> C): A ==> C = ==>(s"chainRule(${p1.show}, ${p2.show})")

}
