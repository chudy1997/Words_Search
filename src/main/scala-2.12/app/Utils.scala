package app

/**
  * Created by Karol on 2017-06-23.
  */
class Utils {
  def printMapConsole(t: Array[Array[Char]],size: Int){
    for(i<-0 until size){
      for(j<-0 until size)
        print(" "+t(i)(j)+" ")
      println()
    }
  }
}
