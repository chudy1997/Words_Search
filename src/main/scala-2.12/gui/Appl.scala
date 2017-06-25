package gui

import app.Categories.ANIMALS

import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.{DropShadow, ImageInput}
import scalafx.scene.layout.HBox
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.scene.image.{Image, ImageView}
import app.WordsGenerator

import scalafx.scene.control.Label

/**
  * Created by Karol on 2017-06-24.
  */

object Appl extends JFXApp{
  stage = new JFXApp.PrimaryStage {
    title = "CrossWords"
    scene = new Scene(800,600) {
     fill = Color.rgb(38, 38, 38)
      content = List(new HBox {
        padding = Insets(18,700,18,100)
        children = Seq(
          new Text {
            text = "CROSS"
            style = "-fx-font: normal bold 60pt sans-serif"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(Color.Yellow, Color.DarkGoldenrod))
            effect = new DropShadow {
              color = Color.Green
              radius = 40
              spread = 0.25
            }
          },
          new Text {
            text = "WORDS"
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
        )
        }
      )
      //...............
      var boardCells = List[ImageView]()
      val generator=new WordsGenerator
      val arr = generator.buildBoard(ANIMALS,2, 10)
      for(i <- 0 until 10) {
        for (j <- 0 until 10) {
         // val image = if (i==j) new Image("file:Images/a2.png") else new Image("file:Images/b.png")
          val image = new Image("file:Images/"+arr(i)(j)+".png")
          val cell = new ImageView(image){
            layoutX = 400 - 5* 36 - 1 + i * 36
            layoutY = 120 + j * 36
          }

          boardCells ::= cell
          content.add(cell)
        }
      }
      //...........
    }
  }
}
