import backend.Directions.offset
import backend.{Categories, Directions, WordsGenerator}
import org.scalatest._


class CategoriesTest extends FlatSpec {
  "Categories" should "match the appropriate category to the given name-string" in {
    assertResult(Categories.Imiona) {
      Categories.convert("Imiona")
    }
    assertResult(Categories.Kosmos) {
      Categories.convert("Kosmos")
    }
    assertResult(Categories.Morza) {
      Categories.convert("Morza")
    }
    assertResult(Categories.Państwa) {
      Categories.convert("Państwa")
    }
    assertResult(Categories.Rośliny) {
      Categories.convert("Rośliny")
    }
    assertResult(Categories.Samochody) {
      Categories.convert("Samochody")
    }
    assertResult(Categories.Stolice) {
      Categories.convert("Stolice")
    }
    assertResult(Categories.Zawody) {
      Categories.convert("Zawody")
    }
    assertResult(Categories.Zwierzęta) {
      Categories.convert("Zwierzęta")
    }
  }
}
class DirectionsTest extends FlatSpec {
  "Directions" should "appropriately calculate offsets for the given direction" in {
    assertResult((1, 0)){
      offset(Directions.R)
    }
    assertResult((0, 1)){
      offset(Directions.D)
    }
    assertResult((-1, 0)){
      offset(Directions.L)
    }
    assertResult((0, -1)){
      offset(Directions.U)
    }
    assertResult((1, 1)){
      offset(Directions.DR)
    }
    assertResult((-1, 1)){
      offset(Directions.DL)
    }
    assertResult((-1, -1)){
      offset(Directions.UL)
    }
    assertResult((1, -1)){
      offset(Directions.UR)
    }
  }
}

class WGGenWordsTest extends FlatSpec {
  "Generated word list" should "not have words longer than the given size" in {
    WordsGenerator.buildBoard(1, Categories.Zwierzęta, 5, 10)
    val words = WordsGenerator.wordset
    assertResult(true){
      !words.exists(_.length>10)
      }
    }
  it should "not contain duplicates" in {
    WordsGenerator.buildBoard(1, Categories.Zwierzęta, 5, 10)
    val words = WordsGenerator.wordset
    val wset = words.toSet
    assert(words.length == wset.size)
  }
  it should "be sorted by length" in {
    WordsGenerator.buildBoard(1, Categories.Zwierzęta, 5, 10)
    val words = WordsGenerator.wordset
    val sorted = words.sortWith { (s1, s2) => s1.length > s2.length }
    assert(words.equals(sorted))
  }

  it should "have the given number of words" in {
    WordsGenerator.buildBoard(1, Categories.Zwierzęta, 5, 10)
    val words = WordsGenerator.wordset
    assert(words.length == 5)
  }
}

class WGBuildBoardTest extends FlatSpec {
  "Board" should "be of the given size" in {
    val board = WordsGenerator.buildBoard(1, Categories.Stolice, 5,10)
    assert(board.length == 10)
    for(subboard <- board)
      assert(subboard.length == 10)
  }
  it should "only contain permitted characters" in {
    val chars = Array('A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł',
    'M', 'N', 'Ń', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'Ś', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ź', 'Ż')
    val board = WordsGenerator.buildBoard(1, Categories.Stolice, 5,10)
    for (i <- 0 until 10; j <- 0 until 10)
      assert(chars.contains(board(i)(j)))
  }
}
