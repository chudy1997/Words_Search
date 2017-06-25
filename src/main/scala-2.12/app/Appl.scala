/**
  * Created by Karol on 2017-05-26.
  */
package app

import app.Categories._

object Appl extends App{
  val n=2
  val size=10
  val utils=new Utils
  val generator=new WordsGenerator
  utils.printMapConsole(generator.buildBoard(ANIMALS,n,size),size)
}
