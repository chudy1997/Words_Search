package gui

import java.util.Calendar

import backend.{Categories, WordsGenerator}

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.text.{Text, TextAlignment}
import scalafx.stage.Stage

object Game {
  def startGame(stage: Stage, mainScene: Scene, level: Int, category: String): Unit = {
    val startTime = Calendar.getInstance().getTimeInMillis
    val boardCells = Array.ofDim[ImageView](10, 10)
    val arr = WordsGenerator.buildBoard(level, Categories.convert(category), 8, 10)
    var wordset = WordsGenerator.wordset
    var leftToFind = wordset.length
    val keywords = wordset.length

    val lostScene = new Scene(800, 600) {
      absScene(this)
      val text = new Text(100, 180, "YOU LOST") {
        wrappingWidth = 600
        textAlignment = TextAlignment.Center
        style = "-fx-font: normal bold 60pt sans-serif"
        fill = col
      }
      val notFoundText = new Text(100, 250, "Unfound words\n") {
        wrappingWidth = 600
        textAlignment = TextAlignment.Center
        style = "-fx-font: normal bold 25pt sans-serif"
        fill = col
      }
      val notFound = new Text(100, 285, "") {
        wrappingWidth = 600
        textAlignment = TextAlignment.Center
        style = "-fx-font: normal bold 15pt sans-serif"
        fill = col
      }
      val menuButton = new Button("Menu") {
        absButton(this)
        layoutX = 300
        layoutY = 460
        prefWidth = 200
        prefHeight = 80
        onMouseClicked = (e) => Menu.start()
      }
      content.addAll(text, notFoundText, notFound, menuButton)
    }

    val winScene = new Scene(800, 600) {
      absScene(this)
      val text = new Text(100, 180, "YOU WON") {
        wrappingWidth = 600
        textAlignment = TextAlignment.Center
        style = "-fx-font: normal bold 60pt sans-serif"
        fill = col
      }
      val timeText = new Text(200, 360, "") {
        wrappingWidth = 400
        textAlignment = TextAlignment.Center
        style = "-fx-font: normal bold 30pt sans-serif"
        fill = col
      }
      val menuButton = new Button("Menu") {
        absButton(this)
        layoutX = 300
        layoutY = 450
        prefWidth = 200
        prefHeight = 80
        onMouseClicked = (e) => Menu.start()
      }
      content.addAll(text, menuButton, timeText)
    }

    val gameScene = new Scene(800, 600) {
      absScene(this)
      val giveupButton = new Button("Give up") {
        absButton(this)
        layoutX = 275
        layoutY = 500
        prefWidth = 250
        prefHeight = 50
        onMouseClicked = (e) => {
          lostScene.notFound.text.value = wordset.mkString("\n")
          stage.scene = lostScene
        }
      }
      val wordsLeft = new Text(630, 150, "Left: " + leftToFind) {
        style = "-fx-font: normal bold 20pt sans-serif"
        fill = col
      }
      val wordsFound = new Text(630, 200, "Found: " + (keywords - leftToFind)) {
        style = "-fx-font: normal bold 20pt sans-serif"
        fill = col
      }
      content.addAll(giveupButton, wordsLeft, wordsFound)

      for (i <- 0 until 10) {
        for (j <- 0 until 10) {
          val image = new Image("file:src/Images/" + arr(i)(j) + ".png")
          val cell = new ImageView(image) {
            layoutX = 400 - 5 * 36 - 1 + j * 36
            layoutY = 120 + i * 36
            mouseTransparent = true
          }

          boardCells(i)(j) = cell
          content.add(cell)
        }
      }
      //.............
      var indexed = Tuple2(-1, -1)
      var signed = List[Tuple2[Int, Int]]()
      var discovered = List[Tuple2[Int, Int]]()
      var indexes = Tuple2(1, 1)
      onMousePressed = (e) => {
        if (e.getX >= 400 - 5 * 36 && e.getX <= 400 - 5 * 36 + 359
          && e.getY >= 121 && e.getY <= 121 + 359) {
          val j = ((e.getX - (400 - 5 * 36)) / 36).toInt
          val i = ((e.getY - 121) / 36).toInt
          indexes = Tuple2(i, j)
        }
      }
      onMouseDragged = (e) => {
        if (e.getX >= 400 - 5 * 36 && e.getX <= 400 - 5 * 36 + 359
          && e.getY >= 121 && e.getY <= 121 + 359 && !indexes.equals(Tuple2(-1, -1))) {
          val j = ((e.getX - (400 - 5 * 36)) / 36).toInt
          val i = ((e.getY - 121) / 36).toInt
          for (cell <- signed)
            if (!discovered.contains(cell))
              dim(cell, boardCells, arr)
          signed = List[Tuple2[Int, Int]]()
          if (i == indexes._1 || i - indexes._1 == j - indexes._2 ||
            j == indexes._2 || i - indexes._1 == -(j - indexes._2)) {
            signed = between(Tuple2(i, j), indexes)
            for (cell <- signed)
              highlight(cell, boardCells, arr)
          }
        }
        else {
          for (cell <- signed)
            if (!discovered.contains(cell))
              dim(cell, boardCells, arr)
          signed = List[Tuple2[Int, Int]]()
        }
      }
      onMouseReleased = (e) => {
        if (e.getX >= 400 - 5 * 36 && e.getX <= 400 - 5 * 36 + 359
          && e.getY >= 121 && e.getY <= 121 + 359) {
          val wMarked = wordMarked(signed, arr)
          val intrsTmp = wordset.intersect(wMarked)
          var intrs = ""
          if (intrsTmp.nonEmpty) intrs = intrsTmp.head
          if (intrsTmp.isEmpty) {
            for (cell <- signed) {
              if (!discovered.contains(cell))
                dim(cell, boardCells, arr)
            }
          }
          else {
            wordset = wordset.filter(!_.equals(intrs)) //?
            leftToFind = wordset.length
            wordsLeft.text = "Left: " + leftToFind
            wordsFound.text = "Found: " + (keywords - leftToFind)
            if (leftToFind == 0) {
              val endTime = Calendar.getInstance().getTimeInMillis
              winScene.timeText.text = "Your time\n" + ((endTime - startTime) / 60000) + " min " + (((endTime - startTime) / 1000)%60) + " sec"
              stage.scene = winScene
            }
            for (cell <- signed)
              discovered ::= cell
          }
          signed = List[Tuple2[Int, Int]]()
        }
      }
      indexes = Tuple2(-1, -1)
    }
    stage.scene = gameScene
  }
}