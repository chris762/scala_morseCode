
// Exercises

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