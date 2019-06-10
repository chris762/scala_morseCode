val salaries = Seq(20000, 70000, 40000)
val doubleSalary = (x: Int) => x * 2
val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)


val salaries2 = Seq(20000, 70000, 40000)
val newSalaries2 = salaries.map(x => x * 2) // List(40000, 140000, 80000)

// The most concise way would be
val salaries3 = Seq(20000, 70000, 40000)
val newSalaries3 = salaries.map(_ * 2)


val string_value = Array("Hello", "There", "Person")
val newLoop = string_value.map(x => x + " From Chris")

//


def addition(f: (Int, Int) => Int,a: Int, b:Int): Int = f(a,b)


val squareSum = (x: Int, y: Int) => x * x + y * y
val cubeSum = (x: Int, y: Int) => x * x * x + y * y * y
val intSum = (x: Int, y: Int) => x + y

val squaredSum = squareSum(1, 2)
val squaredSumHO = addition(squareSum, 1, 2)



//val cubedSum = addition(cubeSum, 1, 2)
//val normalSum = addition(intSum, 1, 2)


def partial1[A,B,C] (a:A, f: (A,B) => C): B => C = {
  b => f(a,b)
}

def curry[A,B,C](f: (A, B) => C): A => B => C = {
  a => b => f(a,b)
}


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