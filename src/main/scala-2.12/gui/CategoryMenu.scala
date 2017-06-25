package gui

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.ComboBox
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Karol on 2017-06-25.
  */
object CategoryMenu extends JFXApp{
  val col=Color.Crimson
  val butBackgroundCol="#00abab" // ?
  stage = new JFXApp.PrimaryStage {
    title = "Words Search"
    scene = new Scene(800, 600) {
      fill = Color.rgb(38, 38, 38)
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
      val chooseText = new Text(180, 180, "Choose category") {
        style = "-fx-font: normal bold 40pt sans-serif"
        fill = col
      }

      val categoryList= new ComboBox(List("animals","countries")){
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        layoutX=200
        layoutY=250
        prefWidth=400
      }

      val footer = new Text(220, 580, "Julia Sypień, KarolBartyzel © 2017. All rights reserved") {
        style = "-fx-font: normal bold 10pt sans-serif"
        fill = col
      }

      content = List(titleText1, titleText2, chooseText,categoryList,footer)
    }
  }
}
