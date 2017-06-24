package app

/**
  * Created by Karol on 2017-06-22.
  */
object Directions extends Enumeration{
  type Directions=Value
  val UR,R,DR,D,DL,L,UL, U = Value

  def rand(): Directions = Directions(scala.util.Random.nextInt(Directions.maxId))
  def offset(dir: Directions): Tuple2[Int,Int] = dir match {
    case UR => (1,-1)
    case R => (1,0)
    case DR => (1,1)
    case D => (0,1)
    case DL => (-1,1)
    case L => (-1,0)
    case UL => (-1,-1)
    case U => (0,-1)
  }
}
