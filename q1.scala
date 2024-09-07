class Rational(n: Int, d: Int) {
  private val g = gcd(n.abs, d.abs)
  val numerator: Int = n / g
  val denominator: Int = d / g

  def neg: Rational = new Rational(-this.numerator, this.denominator)

  def display = println(s"$numerator/$denominator")

  def sub(x: Rational, y: Rational): Rational = {
    if (x.denominator == y.denominator) {
      new Rational(x.numerator - y.numerator, x.denominator)
    } else {
      new Rational(
        x.numerator * y.denominator - y.numerator * x.denominator,
        x.denominator * y.denominator
      )
    }
  }
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
}

@main def main(): Unit = {
  val x = new Rational(3, 4)
  val y = new Rational(5, 8)
  val z = new Rational(2, 7)
  val n = x.sub(y, z)
  n.display

}
