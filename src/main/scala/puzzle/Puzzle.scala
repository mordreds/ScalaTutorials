package puzzle

import scala.collection.mutable.ListBuffer

object Puzzle {

  def reverseArray(arr:List[Int]) = {

    var list = new ListBuffer[Int]()

    val arrSize= arr.length

    for (item <- arr) list += item

    list
  }

  def main(args: Array[String]): Unit = {

    val binaryList = List("00100", "11110", "10110", "10111", "10101", "01111",
      "00111", "11100", "10000", "11001", "00010", "01010")

    val aList = List(1,2,3,5,4,4,5)

    println(reverseArray(aList))
  }

  def calculateGammaRate(aList:List[String]) = {

    val mostFrequentBitList = new ListBuffer[Int]()

    for (index <- 0 until 4 )
      retrieveMostFrequentBitInColumn(aList, index)

    mostFrequentBitList
  }


  def epsilonRate(aList: List[String]):  Int = ???

  def powerConsumption: Int = ???

  def retrieveMostFrequentBitInColumn(aList: List[String], listColumn: Int): Int = {

    val columnAccumulator = new ListBuffer[Char]()

    for (a <- aList)
      columnAccumulator += a.charAt(listColumn)

    val mostCommonItem: Int = columnAccumulator
      .groupBy(identity)
      .view.mapValues(_.size)
      .maxBy(_._2)
      ._1

    mostCommonItem
  }
}
