// Simple example
def add(x: Int, y: Int) = x + y

add(2, 4)


//Curried Function
def add2(x: Int) = (y: Int ) => x + y

add2(20)(10)

// Can even use partial application by assigning to variable
val sum40 = add2(40)
//now you can call your variable with the second paramater (y in this case)
sum40(100)


//Newer syntax (simpler - but can't be a partial application without underscore)
def add3(x: Int) (y: Int) = x + y
val sum50 = add3(100)_ // Note that you have to use _ for a placeholder
sum50(200)



// More examples

def add4(x:Int)(y:String) = x + y

var mynewval = add4(1)_
mynewval("Hello there!")



def courseAverage(tests:Int*) (assns:Int*) (quizzes:Int*) = {
  0.4*tests.sum/tests.length+0.4*assns.sum/assns.length+0.2*quizzes.sum/quizzes.length
}

courseAverage(90, 80)(100, 96) (50, 32)


//Uncurried
def nomalAdd(x: Int, y:Int) = x + y


// Free variable
val p = 100

def getHike(salary: Double) = salary * p/100


//

def isSorted[A](as: Array[A], gt: (A,A) => Boolean): Boolean = {
  @annotation.tailrec
  def go(n: Int): Boolean =
    if (n >= as.length-1) true
    else if (gt(as(n), as(n+1))) false
    else go(n+1)

  go(0)
}

