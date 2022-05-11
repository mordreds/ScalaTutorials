package puzzle

import scala.collection.mutable.ListBuffer

object Puzzle {
  
  enum ORDER {
    case MOST_COMMON
    case LEAST_COMMON
  }

  def main(args: Array[String]): Unit = {

    val binaryList = List(
      "00100",
      "11110",
      "10110",
      "10111",
      "10101",
      "01111",
      "00111",
      "11100",
      "10000",
      "11001",
      "00010",
      "01010"
    )

    val gammaRate = gammaRateBinaryList(binaryList)

    val epsilonRate = epsilonRateBinaryList(binaryList)

    val powerConsumption = gammaRate * epsilonRate

    println(s"Power Consumption is :: $powerConsumption Watts")
  }

  def gammaRateBinaryList(aList:List[String]) : Long = {
    val res = for (idx <- 0 until aList.head.length)
      yield retrieveMostFrequentBitInColumn(aList,idx,ORDER.MOST_COMMON)

    val gammaRate: String =  res.foldLeft("")(_+_)

    val decimalNumber: DecimalNumber = new DecimalNumber()

    decimalNumber.binaryToDecimal(gammaRate)
  }

  def epsilonRateBinaryList(aList: List[String]) : Long =
  {
    val res = for (idx <- 0 until aList.head.length)
      yield retrieveMostFrequentBitInColumn(aList,idx,ORDER.LEAST_COMMON)

    val epsilonRate = res.foldLeft("")(_+_)

    val decimalNumber: DecimalNumber = new DecimalNumber()

    decimalNumber.binaryToDecimal(epsilonRate)
  }

  def retrieveMostFrequentBitInColumn(aList: List[String], listColumn: Int, order: ORDER) : Char = {

    // group list elements into map of unique key and list of its occurrences
    // output :: HashMap(1 -> List(1, 1, 1, 1, 1, 1, 1), 0 -> List(0, 0, 0, 0, 0))
    val columnAccumulator: Map[Char, List[Char]] = aList.map(bit => bit.charAt(listColumn)).groupBy(identity)

    order match {
       case ORDER.MOST_COMMON => columnAccumulator.view
         .mapValues(_.size) // return Map( 1 -> 7, 0 -> 5)
         .maxBy(_._2) // get highest map value
         ._1 // return its key

       case ORDER.LEAST_COMMON => columnAccumulator.view
         .mapValues(_.size)
         .minBy(_._2)
         ._1
     }
  }
}

// didnt find a direct conversion so copied this class from online
class DecimalNumber()
{
  def binaryToDecimal(number: String): Long = {
    // Assuming that number contains 0,1s
    // Used to store result
    var result: Long = 0
    var bit: Int = 0
    var n: Int = number.length() - 1
    // Display Binary number
    // Execute given number in reverse order
    while (n >= 0)
    {
      if (number.charAt(n) == '1')
      {
        // When get binary 1
        result += 1.<<(bit)
      }
      n = n - 1
      // Count number of bits
      bit += 1
    }
    // Display decimal result
    result
  }
}
