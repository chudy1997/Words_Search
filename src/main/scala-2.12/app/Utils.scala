package app

import scala.collection.mutable
import scalafx.scene.image.{Image, ImageView}

/**
  * Created by Karol on 2017-06-23.
  */
class Utils {
  def printMapConsole(t: Array[Array[Char]], size: Int) {
    for (i <- 0 until size) {
      for (j <- 0 until size)
        print(" " + t(i)(j) + " ")
      println()
    }
  }

  def between(t1: Tuple2[Int, Int], t2: Tuple2[Int, Int]): List[Tuple2[Int, Int]] = {
    var res = List[Tuple2[Int, Int]]()
    if (t1._1 == t2._1) {
      if (t1._2 < t2._2) {
        for (j <- t1._2 to t2._2)
          res ::= Tuple2(t1._1, j)
      }
      else {
        for (j <- t2._2 to t1._2)
          res ::= Tuple2(t1._1, j)
      }
    }
    else if (t1._1 - t2._1 == t1._2 - t2._2) {
      if (t1._1 < t2._1) {
        var i = t1._1
        var j = t1._2
        while (!(i > t2._1)) {
          res ::= Tuple2(i, j)
          i += 1
          j += 1
        }
      }
      else {
        var i = t2._1
        var j = t2._2
        while (!(i > t1._1)) {
          res ::= Tuple2(i, j)
          i += 1
          j += 1
        }
      }
    }
    else if (t1._2 == t2._2) {
      if (t1._1 < t2._1) {
        for (i <- t1._1 to t2._1)
          res ::= Tuple2(i, t1._2)
      }
      else {
        for (i <- t2._1 to t1._1)
          res ::= Tuple2(i, t1._2)
      }
    }
    else if (t1._1 - t2._1 == -(t1._2 - t2._2)) {
      if (t1._1 < t2._1) {
        var i = t1._1
        var j = t1._2
        while (!(i > t2._1)) {
          res ::= Tuple2(i, j)
          i += 1
          j -= 1
        }
      }
      else {
        var i = t2._1
        var j = t2._2
        while (!(i > t1._1)) {
          res ::= Tuple2(i, j)
          i += 1
          j -= 1
        }
      }
    }
    res
  }

  def wordMarked(signed: List[Tuple2[Int, Int]], arr: Array[Array[Char]]): mutable.MutableList[String] = {
    val betw1 = signed
    val betw2 = signed.reverse
    var s1 = ""
    var s2 = ""
    for (cell <- betw1)
      s1 += arr(cell._1)(cell._2)
    for (cell <- betw2)
      s2 += arr(cell._1)(cell._2)
    val res = new mutable.MutableList[String]()
    res += s1
    res += s2
    res
  }

  def highlight(cell: Tuple2[Int, Int], cellBoard: Array[Array[ImageView]], arr: Array[Array[Char]]) {
    cellBoard(cell._1)(cell._2).image = new Image("file:Images/" + arr(cell._1)(cell._2) + "2.png")
  }

  def dim(cell: Tuple2[Int, Int], cellBoard: Array[Array[ImageView]], arr: Array[Array[Char]]) {
    cellBoard(cell._1)(cell._2).image = new Image("file:Images/" + arr(cell._1)(cell._2) + ".png")
  }

}
