package gui

import scalafx.application.JFXApp
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

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
    }
  }
}
