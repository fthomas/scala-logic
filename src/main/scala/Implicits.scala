import Logic._

trait Implicits0 extends Implicits1 {
  implicit def disjunctionAssociativity[A, B, C]: ((A Or B) Or C) ==> (A Or (B Or C)) = ==>("disjunctionAssociativity")
}

trait Implicits1 extends Implicits2 {
  implicit def conjunctionCommutativity[A, B]: (A And B) ==> (B And A) = ==>("conjunctionCommutativity")
}

trait Implicits2 extends Implicits3 {
  implicit def modusTollens[A, B](implicit p1: A ==> B): Not[B] ==> Not[A] = ==>(s"modusTollens(${p1.show})")
}

trait Implicits3 extends Implicits4 {
  implicit def deMorgansLaw2[A, B]: Not[A Or B] ==> (Not[A] And Not[B]) = ==>("deMorgansLaw2")
}

trait Implicits4 extends Implicits5 {
  implicit def deMorgansLaw1[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) = ==>("deMorgansLaw1")
}

trait Implicits5 extends Implicits6 {
  implicit def doubleNegationElimination[A]: Not[Not[A]] ==> A = ==>("doubleNegationElimination")
}

trait Implicits6 {
  implicit def chainRule[A, B, C](implicit p1: A ==> B, p2: B ==> C): A ==> C = ==>(s"chainRule(${p1.show}, ${p2.show})")
}
