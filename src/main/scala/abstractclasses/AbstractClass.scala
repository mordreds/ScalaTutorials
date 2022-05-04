package abstractclasses

object AbstractClasses extends App {
  val newDog = new Dog("Scobby")

  newDog.localScope
}

abstract class Animal {

  val nameOfAnimal: String

  val soundMadeByAnimal: String

  def speak(): String = s"A $nameOfAnimal makes the sound $soundMadeByAnimal"
}

class Dog(name:String) extends Animal {
  override val nameOfAnimal = name

  override val soundMadeByAnimal: String = "Whoa"

  println(super.speak())

  def localScope = println("This is the Dog class")
}
