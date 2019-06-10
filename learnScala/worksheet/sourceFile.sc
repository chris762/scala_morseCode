import scala.io.Source

val incomingFile = "/Users/chris/Desktop/morseCode/id_letters.csv"

val new_map: scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map[String,String]()

def makeMap(incomingFile: String): scala.collection.mutable.Map[String,String] = {
  val file = Source.fromFile(incomingFile)
  for {
    line <- file.getLines()
    cols = line.split(",").map(_.trim)
    head :: tail = cols
  }

}


for (line <- file.getLines) {
  val cols = line.split(",").map(_.trim)
  new_map += (cols(0) -> cols(1))
}
new_map



/*
//parseLines splits each line on a comma and parses each line.
def parseLines(lines: Array[String]): Array[(String, String)] = {
  lines.map(_.split(",")).map(parseLine)
}

//parseLine turns an incoming line into a tuple
def parseLine(line: Array[String]): (String, String) = {
  ( line(0), line(1) )
}

// Utilizes built in function which turns an array of tuples into an immutable Map
def makeMapBuiltIn(listTuples: Array[(String, String)]): Map[String, String] = {
  listTuples.toMap
}

//toMap starts with an empty map
//Folds over the tuples provided, combining into one map.
def toMap(listTuples: Array[(String, String)]): Map[String, String] = {
  val initial = Map.empty[String, String]
  listTuples.foldLeft(initial)((x,y) => {
    x + y
  })
}

