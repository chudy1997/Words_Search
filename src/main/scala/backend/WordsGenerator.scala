/**
  * Created by Karol on 2017-05-26.
  */

package backend

import backend.Categories.Categories
import backend.Directions._

import scala.collection.mutable
import scala.util.Random

object WordsGenerator {
  private val letters: Array[Char] = Array('A', 'Ą', 'B', 'C', 'Ć', 'D', 'E', 'Ę', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'Ł',
    'M', 'N', 'Ń', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'Ś', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'Ź', 'Ż')
  var wordset = new mutable.MutableList[String]()
  private val rand = new Random()

  private def chooseWordsFromCategory(category: Categories, n: Int, size: Int): mutable.MutableList[String] = {
    val source = io.Source.fromFile("src/words/" + new String(category.toString) + ".txt")
    val allWords =
      try
        source.mkString.split("\n").mkString("").split(",")
      finally source.close()
    val res = new mutable.MutableList[String]()
    var tmp = ""

    for (i <- 1 to n) {
      do
        tmp = allWords(rand.nextInt(allWords.length))
      while (tmp.length > size || res.contains(tmp))
      res += tmp
    }
    res.sortWith { (s1, s2) => s1.length > s2.length }
  }

  private def checkAvailability(res: Array[Array[Char]], s: String, x: Int, y: Int, dir: Directions): Boolean = {
    var xTmp = x
    var yTmp = y
    for (letter <- s) {
      if (res(xTmp)(yTmp) != ' ' && res(xTmp)(yTmp) != letter)
        return false
      val offset = Directions.offset(dir)
      xTmp += offset._1
      yTmp += offset._2
    }
    true
  }

  def buildBoard(level: Int, category: Categories, n: Int, size: Int): Array[Array[Char]] = {
    val words = chooseWordsFromCategory(category, n, size)
    wordset = words
    val res = Array.ofDim[Char](size, size)
    for (i <- 0 until size; j <- 0 until size)
      res(i)(j) = ' '
    for (i <- words.indices)
      words(i) = words(i).trim.toUpperCase()
    words.foreach((s) => {
      var dir: Directions = null
      var indX = -1
      var indY = -1
      do {
        dir = Directions.rand(level)
        dir match {
          case R =>
            indX = rand.nextInt(size + 1 - s.length)
            indY = rand.nextInt(size)
          case D =>
            indX = rand.nextInt(size)
            indY = rand.nextInt(size + 1 - s.length)
          case L =>
            indX = size - 1 - rand.nextInt(size + 1 - s.length)
            indY = rand.nextInt(size)
          case U =>
            indX = rand.nextInt(size)
            indY = size - 1 - rand.nextInt(size + 1 - s.length)
          case DR =>
            indX = rand.nextInt(size + 1 - s.length)
            indY = rand.nextInt(size + 1 - s.length)
          case DL =>
            indX = size - 1 - rand.nextInt(size + 1 - s.length)
            indY = rand.nextInt(size + 1 - s.length)
          case UL =>
            indX = size - 1 - rand.nextInt(size + 1 - s.length)
            indY = size - 1 - rand.nextInt(size + 1 - s.length)
          case UR =>
            indX = rand.nextInt(size + 1 - s.length)
            indY = size - 1 - rand.nextInt(size + 1 - s.length)
        }
      }
      while (!checkAvailability(res, s, indX, indY, dir))
      for (c <- s) {
        res(indX)(indY) = c
        val offset = Directions.offset(dir)
        indX += offset._1
        indY += offset._2
      }
    })
    for (i <- 0 until size; j <- 0 until size)
      if (res(i)(j) == ' ')
        res(i)(j) = letters(rand.nextInt(letters.length))
    res
  }
}
