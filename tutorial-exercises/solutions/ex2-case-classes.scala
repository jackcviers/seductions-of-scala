// Exercise 2: A Rational Number Case Class
// There are several parts we're practicing at once; create a case class for
// Rational Numbers, which represent division of one integer
// by another exactly, rather than computing the actual floating point value, 
// which is subject to round-off errors, etc.
// For example, 22/7 would be the value "new Rational(22,7)", rather than
// 3.142857142857143. (I picked this example because 22/7 is famously close to
// the value of Pi.) Here, 22 is the numerator and 7 is the denominator, in this case.
// Here are the rules for +, -, *, /, where r1 = n1/d2 and r2 = n2/d2:
//   r1 + r2    (n1*d2 + n2*d1)/d1*d2
//   r1 - r2    (n1*d2 - n2*d1)/d1*d2
//   r1 * r2    n1*n2/d1*d2
//   r1 / r2    n1*d2/d1*n2
//
// Create a case class for Rational. Recall how numbers work in math; they 
// aren't mutable! So, don't use "var" anywhere.
//
// Add methods for at least +, -, or all four operators if you want.
// Do you like the output of the generated toString? If not, what would be better?
// implement it.

/* --------------------- */
/* Define Rational here: */

case class Rational(numerator: Int, denominator: Int = 1) {
  def + (r2: Rational) = 
    new Rational(numerator * r2.denominator + r2.numerator * denominator, 
                 denominator * r2.denominator)

  def - (r2: Rational) = 
    new Rational(numerator * r2.denominator - r2.numerator * denominator, 
                 denominator * r2.denominator)

  def * (r2: Rational) = 
    new Rational(numerator * r2.numerator, denominator * r2.denominator)

  def / (r2: Rational) = 
    new Rational(numerator * r2.denominator, denominator * r2.numerator)
                 
  override def toString = numerator + "/" + denominator
}
/* --------------------- */

import CheapTests._

// Note that we don't need to use new:
val r1 = Rational(22, 7)
val r2 = Rational(11, 3)
r1.numerator   is 22
r1.denominator is 7
r2.numerator   is 11
r2.denominator is 3
(r1 + r2).toString is "143/21"
(r2 + r1).toString is "143/21"
(r1 - r2).toString is "-11/21"
(r2 - r1).toString is "11/21"
(r1 * r2).toString is "242/21"
(r2 * r1).toString is "242/21"
(r1 / r2).toString is "66/77"
(r2 / r1).toString is "77/66"

val r3 = r1.copy(denominator = 1)
r3.numerator   is 22
r3.denominator is 1

// Add a default value of 1 for the "denominator" argument
// to make the next line compile:
val r4 = Rational(10)
r4.numerator   is 10
r4.denominator is 1

println("Success!")