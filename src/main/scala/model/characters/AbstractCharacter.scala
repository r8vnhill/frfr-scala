
package cl.ravenhill.oop.frfr
package model.characters

abstract class AbstractCharacter protected(override val name: String)
  extends GameCharacter {

  override def attack(target: GameCharacter): Unit = {
    println(s"$name attacks ${target.name}")
  }

  override def isAlive: Boolean = ???
}
