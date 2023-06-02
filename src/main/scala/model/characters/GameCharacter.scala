package cl.ravenhill.oop.frfr
package model.characters

trait GameCharacter {
  def isAlive: Boolean
  val name: String
  def attack(target: GameCharacter): Unit
}
