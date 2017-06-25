package app

/**
  * Created by Karol on 2017-05-26.
  */
object Categories extends Enumeration{
  type Categories=Value
  val COUNTRIES, ANIMALS = Value

  def convert(s: String): Categories = {
    for(c<-values)
      if(c.toString.equals(s))
        return c
    null
  }
}
