import Logic._

object Test extends App {
  def conjunctionCommutativity[A, B] = implicitly[(A And B) ==> (B And A)]
  println("conjunctionCommutativity: " + conjunctionCommutativity.show)

  def disjunctionAssociativity[A, B, C] = implicitly[((A Or B) Or C) ==> (A Or (B Or C))]
  println("disjunctionAssociativity: " + disjunctionAssociativity.show)

  def deMorgansLaw1Subst[A, B] = implicitly[Not[Not[A] Or Not[B]] ==> (A And B)]
  println("deMorgansLaw1Subst: " + deMorgansLaw1Subst.show)

  def deMorgansLaw2Subst[A, B] = implicitly[Not[Not[A] And Not[B]] ==> (A Or B)]
  println("deMorgansLaw2Subst: " + deMorgansLaw2Subst.show)
}
