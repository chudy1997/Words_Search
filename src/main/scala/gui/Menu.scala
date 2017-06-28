package gui

import scalafx.application.JFXApp
import scalafx.geometry.Pos
import scalafx.scene.Scene
import scalafx.scene.control.{Button, ComboBox}
import scalafx.scene.text.{Text, TextAlignment}

object Menu extends JFXApp {
  var level = 0
  var category: String = ""
  stage = new JFXApp.PrimaryStage {
    title = "Words Search"
  }

  val mainScene = new Scene(800, 600) {
    absScene(this)
    val chooseText = new Text(50, 180, "Welcome to Words Search") {
      wrappingWidth = 700
      textAlignment = TextAlignment.Center
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val butStart = new Button("Start") {
      absButton(this)
      layoutX = 275
      layoutY = 225
      prefWidth = 250
      prefHeight = 75
    }
    val butOptions = new Button("Options") {
      absButton(this)
      layoutX = 275
      layoutY = 350
      prefWidth = 250
      prefHeight = 75
    }
    val butExit = new Button("Exit") {
      absButton(this)
      layoutX = 275
      layoutY = 475
      prefWidth = 250
      prefHeight = 75
    }
    content.addAll(chooseText, butStart, butOptions, butExit)
  }

  val levelScene = new Scene(800, 600) {
    absScene(this)
    val chooseText = new Text(200, 150, "Choose level") {
      wrappingWidth = 400
      textAlignment = TextAlignment.Center
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val butEasy = new Button("Easy") {
      absButton(this)
      layoutX = 275
      layoutY = 190
      prefWidth = 250
      prefHeight = 70
      onMouseClicked = (e) => {
        level = 1
        categoryScene.categoryList.selectionModel.apply().clearSelection()
        stage.scene = categoryScene
      }
    }
    val butMedium = new Button("Medium") {
      absButton(this)
      layoutX = 275
      layoutY = 280
      prefWidth = 250
      prefHeight = 70
      onMouseClicked = (e) => {
        level = 2
        categoryScene.categoryList.selectionModel.apply().clearSelection()
        stage.scene = categoryScene
      }
    }
    val butHard = new Button("Hard") {
      absButton(this)
      layoutX = 275
      layoutY = 370
      prefWidth = 250
      prefHeight = 70
      onMouseClicked = (e) => {
        level = 3
        categoryScene.categoryList.selectionModel.apply().clearSelection()
        stage.scene = categoryScene
      }
    }
    val butBack = new Button("Back") {
      absButton(this)
      layoutX = 275
      layoutY = 460
      prefWidth = 250
      prefHeight = 70
      onMouseClicked = (e) => stage.scene = mainScene
    }
    content.addAll(chooseText, butEasy, butMedium, butHard, butBack)
  }

  val optionsScene = new Scene(800, 600) {
    absScene(this)
    val backButton = new Button("Back") {
      absButton(this)
      layoutX = 275
      layoutY = 475
      prefWidth = 250
      prefHeight = 75
      onMouseClicked = (e) => {
        stage.scene = mainScene
      }
    }
    content.addAll(backButton)
  }


  val exitScene = new Scene(800, 600) {
    absScene(this)
    val text = new Text(100, 200, "Are you sure to exit?") {
      wrappingWidth = 600
      textAlignment = TextAlignment.Center
      style = "-fx-font: normal bold 40pt sans-serif ; -fx-background-color: " + butBackgroundCol
      fill = col
    }
    val yesButton = new Button("Yes") {
      absButton(this)
      layoutX = 200
      layoutY = 350
      prefWidth = 150
      prefHeight = 80
      onMouseClicked = (e) => System.exit(0)
    }
    val noButton = new Button("No") {
      absButton(this)
      layoutX = 450
      layoutY = 350
      prefWidth = 150
      prefHeight = 80
      onMouseClicked = (e) => stage.scene = mainScene

    }
    content.addAll(text, yesButton, noButton)
  }

  val categoryScene = new Scene(800, 600) {
    absScene(this)
    val chooseText = new Text(100, 160, "Choose category") {
      wrappingWidth = 600
      textAlignment = TextAlignment.Center
      style = "-fx-font: normal bold 40pt sans-serif"
      fill = col
    }
    val categoryList = new ComboBox(List("Imiona", "Kosmos", "Miasta", "Morza", "Państwa", "Rośliny", "Samochody", "Stolice", "Zawody", "Zwierzęta")) {
      style = "-fx-font: normal bold 20pt sans-serif ; -fx-background-color: " + butBackgroundCol
      alignmentInParent = Pos.Center
      layoutX = 75
      layoutY = 200
      prefWidth = 400
      prefHeight = 50
      visibleRowCount = 5
      onAction = (e) => {
        category = this.selectionModel.apply.getSelectedItem
      }
    }

    val confirmButton = new Button("Confirm") {
      absButton(this)
      layoutX = 525
      layoutY = 200
      prefWidth = 200
      prefHeight = 50
      onMouseClicked = (e) => {
        if (!categoryList.selectionModel.apply().isEmpty) Game.startGame(stage, mainScene, level, category)
      }
    }
    val backButton = new Button("Back") {
      absButton(this)
      layoutX = 275
      layoutY = 470
      prefWidth = 250
      prefHeight = 80
    }

    content.addAll(chooseText, categoryList, confirmButton, backButton)
  }

  //filling problematic switches between scenes
  {
    mainScene.butStart.onMouseClicked = (e) => stage.scene = levelScene
    mainScene.butOptions.onMouseClicked = (e) => stage.scene = optionsScene
    mainScene.butExit.onMouseClicked = (e) => stage.scene = exitScene
    categoryScene.onMouseClicked = (e) => stage.scene = levelScene
  }

  def start(): Unit = {
    this.stage.scene = mainScene
  }

  start()
}
