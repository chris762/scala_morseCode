val mylist = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val emptylist = List()

// 3.2
def theTail(a: List[Int]): List[Int] = {
  val newtail = a.tail
  newtail
}

val matcher = mylist match {
  case Nil => "Empty List"
  case _ => mylist.tail
}


// 3.3
def setHead(a: List[Int]) = {
  var newHead = 20
  var newList = List(List(newHead), a.tail)
  var flatten = newList.flatten
  flatten
}


// 3.6
val mynewlist = List(1,2,3,4,5,6)

def init[A](l: List[A]): List[A] = l match {
  case Nil => List.empty
  case l => l.init
  case _ => ???
}

println(init(mynewlist))


// Left and Right folding
val letters = List("a", "b", "c")
letters.foldLeft("") {
  (m: String, n: String) => m + n
}

letters.foldRight("") {
  (m: String, n: String) => m + n
}




// OTHER EXAMPLES

val aStandardList = List(1,2,3,42)
val standardListMatching = aStandardList match {
  case List(1, _, _, _) => "One"
  case List(1, _*) => "Two"
    //Infix
  case 1 :: List(_) => "Three"
  case List(1,2,3) :+ 42 => "Four"
}

println(standardListMatching)


// Interesting
val numbers = List(1,2,3)
val numbersMatch = numbers match {
  case aListOfStrings: List[String] => "Strings"
  case aListOfInts: List[Int] => "Int"
  case _ => ""
}

println(numbersMatch)