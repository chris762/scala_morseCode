import scala.io.Source

class FileParser {


  val new_map: scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map[String,String]()

  def makeMap(incomingFile: String): scala.collection.mutable.Map[String,String] = {
    val file = Source.fromFile(incomingFile)
    for (line <- file.getLines) {
      val cols = line.split(",").map(_.trim)
      new_map += (cols(0) -> cols(1))
    }
    new_map
  }

  val master_map: scala.collection.mutable.Map[String,String] = scala.collection.mutable.Map[String,String]()

  def makeMasterMap(letters: scala.collection.mutable.Map[String,String], codes: scala.collection.mutable.Map[String,String]): scala.collection.mutable.Map[String,String] = {
    for(ck <- letters.keySet){
      for(lk <- codes.keySet){
        if(ck == lk){
          master_map += (letters(lk) -> codes(ck))
        }
      }
    }
    master_map
  }
}