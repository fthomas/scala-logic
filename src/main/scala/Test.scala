import Logic._

object Test extends App {
  def deMorgansLaw1Subst[A, B] = implicitly[Not[Not[A] Or Not[B]] ==> (A And B)]
  println("deMorgansLaw1Subst: " + deMorgansLaw1Subst.show)

  def deMorgansLaw2Subst[A, B] = implicitly[Not[Not[A] And Not[B]] ==> (A Or B)]
  println("deMorgansLaw2Subst: " + deMorgansLaw2Subst.show)
}
