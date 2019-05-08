class CharacterMapper {

  def findMatch(strComparison: String, masterMap: scala.collection.mutable.Map[String,String]): Unit = {
    for (i <- strComparison) {
      if (masterMap.contains(s"$i")) {
        println(s"$i : " + masterMap(s"$i"))
      }
      else {
        println("?")
      }
    }
  }

}
