import scala.collection.mutable
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.{Text, TextAlignment}

/**
  * Created by Karol on 2017-06-28.
  */
package object gui {
  val col = Color.Crimson
  val butBackgroundCol = "#00abab"
  val hoverColor = "#00ff00"

  def absScene(scene: => Scene): Unit = {
    scene.fill = Color.rgb(38, 38, 38)
    val titleText1 = new Text(70, 82, "WORDS") {
      style = "-fx-font: normal bold 60pt sans-serif"
      fill = new LinearGradient(
        endX = 0,
        stops = Stops(Color.Yellow, Color.DarkGoldenrod))
      effect = new DropShadow {
        color = Color.Green
        radius = 40
        spread = 0.25
      }
    }
    val titleText2 = new Text(370, 82, "SEARCH") {
      style = "-fx-font: italic bold 60pt sans-serif"
      fill = new LinearGradient(
        endX = 0,
        stops = Stops(Color.White, Color.DarkCyan)
      )
      effect = new DropShadow {
        color = Color.Green
        radius = 40
        spread = 0.25
      }
    }
    val footer = new Text(200, 580, "Julia Sypień, KarolBartyzel © 2017. All rights reserved") {
      wrappingWidth = 400
      textAlignment = TextAlignment.Center
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }
    scene.content = List(titleText1, titleText2, footer)
  }

  def absButton(button: => Button): Unit = {
    button.style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
    button.textFill = col
    button.onMouseEntered = (e) => {
      button.style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
    }
    button.onMouseExited = (e) => {
      button.style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
    }
  }

  def between(t1: Tuple2[Int, Int], t2: Tuple2[Int, Int]): List[Tuple2[Int, Int]] = {
    var res = List[Tuple2[Int, Int]]()
    if (t1._1 == t2._1) {
      if (t1._2 < t2._2)
        for (j <- t1._2 to t2._2)
          res ::= Tuple2(t1._1, j)
      else
        for (j <- t2._2 to t1._2)
          res ::= Tuple2(t1._1, j)
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
      if (t1._1 < t2._1)
        for (i <- t1._1 to t2._1)
          res ::= Tuple2(i, t1._2)
      else
        for (i <- t2._1 to t1._1)
          res ::= Tuple2(i, t1._2)
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
    cellBoard(cell._1)(cell._2).image = new Image("file:src/Images/" + arr(cell._1)(cell._2) + "2.png")
  }

  def dim(cell: Tuple2[Int, Int], cellBoard: Array[Array[ImageView]], arr: Array[Array[Char]]) {
    cellBoard(cell._1)(cell._2).image = new Image("file:src/Images/" + arr(cell._1)(cell._2) + ".png")
  }
}

