package cl.ravenhill.oop.frfr
package model.characters

/** Represents a character in a game.
 *
 * A game character has a name, a state of life (alive or dead), and the ability to attack other
 * game characters.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
trait GameCharacter {
  val name: String
  val maxHealth: Int
  def currentHealth: Int
  def currentHealth_=(value: Int): Unit
  val maxMana: Int
  def currentMana: Int
  def currentMana_=(value: Int): Unit
  def isAlive: Boolean
  def attack(target: GameCharacter): Unit
}
