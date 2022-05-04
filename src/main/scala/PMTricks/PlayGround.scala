package PMTricks

object PlayGround extends App {

  println(ConditionalGuards.positions)

}

object ListPatterns {
  val aList = List(1,2,3,45)
  val strList = List("Array", "List", "Maps", "Tuple")

  // trick #1 - List Extractors
  val mustHaveThree: String = aList match {
    case List(_, _, 3, _) => "3rd Number is 3"
    case _ => "3rd Number is Not 3"
  }

  // trick #2 - varargs(variable argument) pattern =>
  val dontCareAboutTheRest: String = aList match {
    case List(_, 2, _*) => "I only care about number 2"
  }

  // trick #3 - Pre-pending
  val startsWithOne: String = aList match {
    case 1 :: tail => "List Begins With Num 1"
    case Nil => "List is empty"
  }

  // trick #4 - other infix pattern
  val mustBeginWith1andEndWith42: String = aList match {
    case List(1,_*) :+ 45 => "This list begin with 1 and end with 42"
    case _ => "List doesn't begin with num 1 and end in 42"
  }
}

object CaseClassDeconstructions {

  case class Person(name:String, age:Int)

  implicit val morgan:Person = Person("Morgan", 26)

  def ageOverForty(implicit person: Person): String = person match {
    case Person(n,_)  => s"Mr ${n} is Over 40 years"
    case _ => "Check if Person was Passed to Me. Looks like an Animal to me... Haha"
  }
}

object TypeSpecifiers {
  val apiResponseData: Any = """{"students": [ {"name" : "morgan", "age": 26} ]}"""

  val validateApiResponse = apiResponseData  match {
    case _: String => "Api Call Returned The Right Data"
    case _ => "Api Call Returned an Error"
  }
}

object ConditionalGuards {
   val numList = List(1,2,3,4,5,6,7,8,9,10,21)

   val positions: List[String] = numList.map {
     case num if (num % 10) == 1 => s"Congratulations !!! Your Position was :: $num" + "st \n"
     case num if (num % 10) == 2 => s"Congratulations !!! Your Position was :: $num" + "nd \n"
     case num if (num % 10) == 3 => s"Congratulations !!! Your Position was :: $num" + "rd \n"
     case num => s"Good Work Done !! You are $num" + "th \n"
     // alternative patterns
     case num if (num % 10) == 4 | (num % 10) == 5 => ???
   }
}


