package gui

import app.{Categories, Utils, WordsGenerator}

import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.stage.Stage

/**
  * Created by Karol on 2017-06-26.
  */
object Game {
  def startGame(stage: Stage, level: Int,category: String): Unit ={
    stage.scene=new Scene(800,600) {
      fill = Color.rgb(38, 38, 38)
      val titleText1=new Text(70,82,"WORDS"){
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
      val titleText2=new Text(370,82,"SEARCH"){
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

      content=List(titleText1,titleText2)

      var boardCells = List[ImageView]()
      val generator=new WordsGenerator
      val arr = generator.buildBoard(level,Categories.convert(category),10, 10)
      val utils = new Utils
      utils.printMapConsole(arr, 10)
      for(i <- 0 until 10) {
        for (j <- 0 until 10) {
          val image =  new Image("file:Images/"+arr(i)(j)+".png")
          val cell = new ImageView(image) {
            layoutX = 400 - 5 * 36 - 1 + j * 36
            layoutY = 120 + i * 36
            onMouseClicked = {_ => image = new Image("file:Images/"+arr(i)(j)+"2.png")}
          }

          boardCells ::= cell
          content.add(cell)
        }
      }
    }
  }
}
