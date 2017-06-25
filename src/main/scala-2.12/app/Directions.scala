package app

/**
  * Created by Karol on 2017-06-22.
  */
object Directions extends Enumeration{
  type Directions=Value
  val R,D,L,U,DR,DL,UL,UR = Value

  def rand(level: Int): Directions = if(level==1) Directions(scala.util.Random.nextInt(2))
    else if(level==2) Directions(scala.util.Random.nextInt(4))
    else Directions(scala.util.Random.nextInt(8))
  def offset(dir: Directions): Tuple2[Int,Int] = dir match {
    case R => (1,0)
    case D => (0,1)
    case L => (-1,0)
    case U => (0,-1)
    case DR => (1,1)
    case DL => (-1,1)
    case UL => (-1,-1)
    case UR => (1,-1)
  }
}
