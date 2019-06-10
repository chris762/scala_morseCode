
// Exercises 2.X -------------------------------------------------------------

// FIB
import scala.math.BigInt

lazy val fibs: Stream[BigInt] =
  BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => {
    println(s"Evaluating: ${n._1} -> ${n._2}")
    n._1 + n._2
  })

fibs take 20 foreach println


// IS SORTED
val newArrayValue = Array(1, 19, 30, 6)

def isSorted[A](a: Array[A], f: (A,A) => Boolean): Boolean = {
  def looper(n: Int): Boolean =
    if (n >= a.length-1) true
    else if ( f(a(n), a(n+1)) ) false
    else looper( n+1 )

  looper(0)
}

//Helper function
def isSame(x: Int, y:Int): Boolean = {
  x >= y

}

// Can call as a literal
isSorted(newArrayValue, (x: Int, n: Int) => x >= n)

// Or can pass as a function
isSorted(newArrayValue, isSame)


// CURRY
def curry[A,B,C](f: (A, B) => C): A => B => C = {
  a => b => f(a,b)
}

// UNCURRY
def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
  (a,b) => f(a)(b)
}

// COMPOSE
def compose[A,B,C](f: B => C, g: A => B): A => C = {
  a => f(g(a))
}

// Exercises 3.X -------------------------------------------------------------

sealed trait List[+A] // `List` data type, parameterized on a type, `A`
case object Nil extends List[Nothing] // A `List` data constructor representing the empty list
/* Another data constructor, representing nonempty lists. Note that `tail` is another `List[A]`,
which may be `Nil` or another `Cons`.
 */
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List { // `List` companion object. Contains functions for creating and working with lists.
  def sum(ints: List[Int]): Int = ints match { // A function that uses pattern matching to add up a list of integers
    case Nil => 0 // The sum of the empty list is 0.
    case Cons(x,xs) => x + sum(xs) // The sum of a list starting with `x` is `x` plus the sum of the rest of the list.
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x,xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] = // Variadic function syntax
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  val x = List(1,2,3,4,5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }

