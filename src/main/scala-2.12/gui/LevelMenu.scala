package gui

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Karol on 2017-06-24.
  */

object LevelMenu extends JFXApp{
  val col=Color.Crimson
  val butBackgroundCol="#00abab" // ?
  stage = new JFXApp.PrimaryStage {
    title = "Words Search"
    scene = new Scene(800,600) {
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
      val chooseText=new Text(230,180,"Choose level") {
        style = "-fx-font: normal bold 40pt sans-serif"
        fill = col
      }
      val butEasy=new Button("Easy"){
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        this.textFill=col
        layoutX=275
        layoutY=225
        prefWidth=250
        prefHeight=75
      }
      val butMedium=new Button("Medium"){
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        this.textFill=col
        layoutX=275
        layoutY=350
        prefWidth=250
        prefHeight=75
      }
      val butHard=new Button("Hard"){
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        this.textFill=col
        layoutX=275
        layoutY=475
        prefWidth=250
        prefHeight=75
      }
      val footer=new Text(220,580,"Julia Sypień, KarolBartyzel © 2017. All rights reserved"){
        style = "-fx-font: normal bold 10pt sans-serif"
        fill = col
      }

      content=List(titleText1,titleText2,chooseText,butEasy,butMedium,butHard,footer)
    }
  }
}
