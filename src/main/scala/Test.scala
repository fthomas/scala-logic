import Logic._

object Test extends App {
  trait P1
  trait P2

  def doubleNegationElimination1 = implicitly[Not[Not[P1]] ==> P1]
  println("doubleNegationElimination1: " + doubleNegationElimination1.show)

  def doubleNegationElimination2 = implicitly[Not[Not[Not[Not[P1]]]] ==> P1]
  println("doubleNegationElimination2: " + doubleNegationElimination2.show)

  def conjunctionAssociativity[A, B, C] = implicitly[((A And B) And C) ==> (A And (B And C))]
  println("conjunctionAssociativity: " + conjunctionAssociativity.show)

  def conjunctionCommutativity[A, B] = implicitly[(A And B) ==> (B And A)]
  println("conjunctionCommutativity: " + conjunctionCommutativity.show)

  def disjunctionAssociativity[A, B, C] = implicitly[((A Or B) Or C) ==> (A Or (B Or C))]
  println("disjunctionAssociativity: " + disjunctionAssociativity.show)

  def disjunctionCommutativity[A, B] = implicitly[(A Or B) ==> (B Or A)]
  println("disjunctionCommutativity: " + disjunctionCommutativity.show)

  def deMorgansLaw1Subst = implicitly[Not[Not[P1] Or Not[P2]] ==> (P1 And P2)]
  println("deMorgansLaw1Subst: " + deMorgansLaw1Subst.show)

  def deMorgansLaw2Subst[A, B] = implicitly[Not[Not[A] And Not[B]] ==> (A Or B)]
  println("deMorgansLaw2Subst: " + deMorgansLaw2Subst.show)
}
