import Logic._
import shapeless.Lazy

trait Implicits0 extends Implicits1 {
  implicit def disjunctionAssociativity[A, B, C]: ((A Or B) Or C) ==> (A Or (B Or C)) = ==>("disjunctionAssociativity")
}

trait Implicits1 extends Implicits2 {
  implicit def disjunctionCommutativity[A, B]: (A Or B) ==> (B Or A) = ==>("disjunctionCommutativity")
}

trait Implicits2 extends Implicits3 {
  implicit def conjunctionAssociativity[A, B, C]: ((A And B) And C) ==> (A And (B And C)) = ==>("conjunctionAssociativity")
}

trait Implicits3 extends Implicits4 {
  implicit def conjunctionCommutativity[A, B]: (A And B) ==> (B And A) = ==>("conjunctionCommutativity")
}

trait Implicits4 extends Implicits5 {
  implicit def doubleNegationElimination1[A]: Not[Not[A]] ==> A = ==>("doubleNegationElimination1")
}

trait Implicits5 extends Implicits6 {
  implicit def doubleNegationElimination2[A, B](implicit p1: Lazy[A ==> B]): Not[Not[A]] ==> B = ==>(s"doubleNegationElimination2(${p1.value.show})")
}

trait Implicits6 extends Implicits7 {
  implicit def chainRule[A, B, C](implicit p1: Lazy[A ==> B], p2: Lazy[B ==> C]): A ==> C = ==>(s"chainRule(${p1.value.show}, ${p2.value.show})")
}

trait Implicits7 extends Implicits8 {
  implicit def deMorgansLaw1[A, B]: Not[A And B] ==> (Not[A] Or Not[B]) = ==>("deMorgansLaw1")
}

trait Implicits8 extends Implicits9 {
  implicit def deMorgansLaw2[A, B]: Not[A Or B] ==> (Not[A] And Not[B]) = ==>("deMorgansLaw2")
}

trait Implicits9 {
  implicit def modusTollens[A, B](implicit p1: Lazy[A ==> B]): Not[B] ==> Not[A] = ==>(s"modusTollens(${p1.value.show})")
}
