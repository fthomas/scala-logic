import Logic._
import shapeless.Lazy

object Template {
  implicit def disjunctionAssociativity[A, B, C]: ((A Or B) Or C) ==> (A Or (B Or C)) = ==>("disjunctionAssociativity")
  implicit def disjunctionCommutativity[A, B]: (A Or B) ==> (B Or A) = ==>("disjunctionCommutativity")
  implicit def conjunctionAssociativity[A, B, C]: ((A And B) And C) ==> (A And (B And C)) = ==>("conjunctionAssociativity")
  implicit def conjunctionCommutativity[A, B]: (A And B) ==> (B And A) = ==>("conjunctionCommutativity")
  implicit def doubleNegationElimination1[A]: Not[Not[A]] ==> A = ==>("doubleNegationElimination1")
  implicit def doubleNegationElimination2[A, B](implicit p1: Lazy[A ==> B]): Not[Not[A]] ==> B = ==>(s"doubleNegationElimination2(${p1.value.show})")
  implicit def deMorgansLaw2[A, B]: Not[A Or B] ==> (Not[A] And Not[B]) = ==>("deMorgansLaw2")
  implicit def deMorgansLaw1[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) = ==>("deMorgansLaw1")
  implicit def chainRule[A, B, C](implicit p1: Lazy[A ==> B], p2: Lazy[B ==> C]): A ==> C = ==>(s"chainRule(${p1.value.show}, ${p2.value.show})")
  implicit def modusTollens[A, B](implicit p1: Lazy[A ==> B]): Not[B] ==> Not[A] = ==>(s"modusTollens(${p1.value.show})")
}
