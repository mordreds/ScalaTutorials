object Main {

  def main(args: Array[String]): Unit = {
    val str:String = "Hello"

    println( changeToUpper(str))
  }

  def changeToUpper(implicit y:String): String =
    y.toUpperCase()

}
