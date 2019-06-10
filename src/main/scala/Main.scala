object Main {

  def main(args: Array[String]): Unit = {


    //id_letters object
    val id_letters = new FileParser
    val id_letters_map = id_letters.makeMap("id_letters.csv")

    //id_codes object
    val id_codes = new FileParser
    val id_codes_map = id_codes.makeMap("id_codes.csv")

    //Build master map
    val master_m = new FileParser
    val master_map = master_m.makeMasterMap(id_letters_map, id_codes_map)

    //Lets try and print the codes for the string below
    val string_to_compare = "HELLO FROM SCALA!"

    //Try and find/print the matches
    val matcher = new CharacterMapper
    val morseCode: Unit = matcher.findMatch(string_to_compare, master_map)

  }

 }
