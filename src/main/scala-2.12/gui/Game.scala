package gui

import app.{Categories, Utils, WordsGenerator}

import scalafx.scene.Scene
import scalafx.scene.control.Button
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text
import scalafx.stage.Stage

/**
  * Created by Karol on 2017-06-26.
  */
object Game {
  val col=Color.Crimson
  val butBackgroundCol="#00abab" // ?
  val hoverColor="#00ff00"
  def startGame(stage: Stage, mainScene: Scene,level: Int,category: String): Unit ={
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
      val giveupButton=new Button("Give up"){
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        this.textFill=col
        layoutX=275
        layoutY=500
        prefWidth=250
        prefHeight=50
        onMouseEntered=(e)=>{
          style="-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+hoverColor
        }
        onMouseExited=(e)=>{
          style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
        }
      }

      val lostScene=new Scene(800,600) {
        fill = Color.rgb(38, 38, 38)
        val text = new Text(130, 200, "YOU LOST") {
          style = "-fx-font: normal bold 80pt sans-serif"
          fill = col
        }
        val menuButton=new Button("Menu"){
          style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
          this.textFill = col
          layoutX = 300
          layoutY = 450
          prefWidth = 200
          prefHeight = 80
          onMouseEntered = (e) => {
            style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
          }
          onMouseExited = (e) => {
            style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
          }
          onMouseClicked = (e) => {
            Menu.start()
          }
        }
        content=List(text,menuButton)
      }

      giveupButton.onMouseClicked=(e)=>{
        stage.scene=lostScene
      }
      val footer = new Text(220, 580, "Julia Sypień, KarolBartyzel © 2017. All rights reserved") {
        style = "-fx-font: normal bold 10pt sans-serif"
        fill = col
      }
      content=List(titleText1,titleText2,giveupButton,footer)

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
