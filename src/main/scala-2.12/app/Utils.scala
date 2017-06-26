package app

import scalafx.scene.image.Image

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

}
