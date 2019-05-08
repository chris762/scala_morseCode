
import scala.math.BigInt

lazy val fibs: Stream[BigInt] =
  BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => {
      println(s"Evaluating: ${n._1} -> ${n._2}")
      n._1 + n._2
    })

//fibs take 20 foreach println

val myarray = List("this", "that", "another")
val myarrayofint = Array(1, 2, 5, 10 ,100)

def findFirstString (ss: List[String], key: String): Int = {
  def loop (n: Int): Int =
    if (n >= ss.length) -1
    else if (ss(n) == key) n
    else loop (n + 1)

  loop (0)
}
//println(findFirstString(myarray, "another"))

//Different method
def findFirstInt [A] (as: Array[A], p: A => Boolean): Int = {
  def loop (n: Int) : Int =
    if (n >= as.length) -1
    else if (p(as(n))) n
    else loop (n + 1)

  loop(0)
}
//println(findFirstInt(myarrayofint, (x: Int) => x == 9))

val sortedlist = Array(0,1,2,3,4,5)
val unsortedList = Array(0,4,3,5,67,4)

def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
  def go(n: Int): Boolean =
    if (n >= as.length-1) true
    else if (gt(as(n), as(n+1))) false
    else go(n+1)

  go(0)
}

isSorted(unsortedList, (x: Int, y: Int) => x<=y)
