object MapFlatmapFilterFor extends App {

  val list = List(1,2,3)

  //for each is iteration and map is a 1:1 mapping


  //map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)

  println(list.flatMap(toPair))

  //all combos between two lists  (All are just iterations)
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  //now three
  val colors = List("black", "white")

  val combinations2 = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color)))
  println(combinations2)

  //foreach
  list.foreach(println)

  // Regular for loop
  for (i <- numbers){
    println(i + " Chris")
  }

  //for-comprehensions (Chains of map, flatMap and filter done by compiler)
  val forCombinations = for {
    n <- numbers
    // Can use a guard, which will convert to filter as so
    //n <- numbers if N % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  //syntax overload
  val soverload = list.map { x =>
      x * 2
  }
  println(soverload)


  //  MORE
  val months = List("January", "February", "March")

  println(months.map(_.toUpperCase))
  //OR
  //println(months.map(x => x.toUpperCase))

  //abbvr
  val abbvr = months.map(x => x.toUpperCase).map(x => x.substring(0, 3))
  println(abbvr)

  //flatMap
  val isFactorOfThree = (input: Int) => if((input/3.0).isWhole) Some(input) else None
  println(List.range(1,100).flatMap(list => isFactorOfThree(list)))


  //Lunch session

  //Look at zip





}
