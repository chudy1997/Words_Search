package gui

import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ComboBox}
import scalafx.scene.effect.DropShadow
import scalafx.scene.paint.{Color, LinearGradient, Stops}
import scalafx.scene.text.Text

/**
  * Created by Karol on 2017-06-24.
  */

object Menu extends JFXApp{
  val col=Color.Crimson
  val butBackgroundCol="#00abab" // ?
  val hoverColor="#00ff00"
  var level=0
  var category: String=""
  stage = new JFXApp.PrimaryStage {
    title = "Words Search"
  }



  val mainScene=new Scene(800,600) {
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
    val chooseText=new Text(70,180,"Welcome in Words Search") {
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val butStart=new Button("Start"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=225
      prefWidth=250
      prefHeight=75
      onMouseEntered=(e)=>{
        style="-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+hoverColor
      }
      onMouseExited=(e)=>{
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      }
      onMouseClicked=(e)=>{
        println("start")
      }
    }
    val butOptions=new Button("Options"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=350
      prefWidth=250
      prefHeight=75
      onMouseEntered=(e)=>{
        style="-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+hoverColor
      }
      onMouseExited=(e)=>{
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      }
      onMouseClicked=(e)=>{
        println("options")
      }
    }
    val butExit=new Button("Exit"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=475
      prefWidth=250
      prefHeight=75
      onMouseEntered=(e)=>{
        style="-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+hoverColor
      }
      onMouseExited=(e)=>{
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      }
    }
    val footer=new Text(220,580,"Julia Sypień, KarolBartyzel © 2017. All rights reserved"){
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }
    content=List(titleText1,titleText2,chooseText,butStart,butOptions,butExit,footer)
  }



  val levelScene=new Scene(800,600) {
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
    val chooseText=new Text(230,150,"Choose level") {
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val butEasy=new Button("Easy"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=190
      prefWidth=250
      prefHeight=70
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
    }
    val butMedium=new Button("Medium"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=280
      prefWidth=250
      prefHeight=70
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
    }
    val butHard=new Button("Hard"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=370
      prefWidth=250
      prefHeight=70
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
    }
    val butBack=new Button("Back"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      this.textFill=col
      layoutX=275
      layoutY=460
      prefWidth=250
      prefHeight=70
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
    }
    val footer=new Text(220,580,"Julia Sypień, KarolBartyzel © 2017. All rights reserved"){
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }

    content=List(titleText1,titleText2,chooseText,butEasy,butMedium,butHard,butBack,footer)
  }



  val optionsScene=new Scene(800,600) {
    fill = Color.rgb(38, 38, 38)
    val backButton=new Button("Back"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      this.textFill = col
      layoutX=275
      layoutY=475
      prefWidth=250
      prefHeight=75
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
      onMouseClicked = (e) => {
        stage.scene=mainScene
      }
    }
    val footer=new Text(220,580,"Julia Sypień, KarolBartyzel © 2017. All rights reserved"){
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }
    content=List(backButton,footer)
  }



  val exitScene=new Scene(800,600) {
    fill = Color.rgb(38, 38, 38)
    val text = new Text(120, 100, "Are you sure to exit?") {
      style = "-fx-font: normal bold 40pt sans-serif ; -fx-background-color: " + butBackgroundCol
      fill = col
    }
    val yesButton = new Button("Yes") {
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      this.textFill = col
      layoutX = 150
      layoutY = 350
      prefWidth = 150
      prefHeight = 80
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
      onMouseClicked = (e) => {
        System.exit(0)
      }
    }
    val noButton = new Button("No") {
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      this.textFill = col
      layoutX = 450
      layoutY = 350
      prefWidth = 150
      prefHeight = 80
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
      onMouseClicked = (e) => {
        stage.scene = mainScene
      }
    }
    val footer=new Text(220,580,"Julia Sypień, KarolBartyzel © 2017. All rights reserved"){
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }
    content = List(text, yesButton, noButton,footer)
  }



  val categoryScene=new Scene(800, 600) {
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
    val chooseText = new Text(180, 160, "Choose category") {
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val categoryList= new ComboBox(List("Imiona","Kosmos","Miasta","Morza","Państwa","Rośliny","Samochody","Stolice","Zawody","Zwierzęta")){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: "+butBackgroundCol
      layoutX=200
      layoutY=200
      prefWidth=400
      visibleRowCount=5
      onAction=(e)=>{
        category=this.selectionModel.apply.getSelectedItem
        Game.startGame(stage,mainScene,level,category)
      }
    }
    val backButton=new Button("Back"){
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      this.textFill = col
      layoutX = 275
      layoutY = 470
      prefWidth = 250
      prefHeight = 80
      onMouseEntered = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + hoverColor
      }
      onMouseExited = (e) => {
        style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      }
      onMouseClicked = (e) => {
        stage.scene = levelScene
      }
    }

    val footer = new Text(220, 580, "Julia Sypień, KarolBartyzel © 2017. All rights reserved") {
      style = "-fx-font: normal bold 10pt sans-serif"
      fill = col
    }
    content = List(titleText1, titleText2, chooseText,categoryList,backButton,footer)
  }



  mainScene.butStart.onMouseClicked=(e)=>stage.scene=levelScene
  mainScene.butOptions.onMouseClicked=(e)=>stage.scene=optionsScene
  mainScene.butExit.onMouseClicked=(e)=>stage.scene=exitScene
  exitScene.noButton.onMouseClicked=(e)=>stage.scene=mainScene
  levelScene.butEasy.onMouseClicked = (e) => {
    level=1
    stage.scene=categoryScene
  }
  levelScene.butMedium.onMouseClicked = (e) => {
    level=2
    stage.scene=categoryScene
  }
  levelScene.butHard.onMouseClicked = (e) => {
    level=3
    stage.scene=categoryScene
  }
  levelScene.butBack.onMouseClicked= (e) => {
    stage.scene=mainScene
  }
  def start(): Unit ={
    this.stage.scene=mainScene
  }
  start()
}
