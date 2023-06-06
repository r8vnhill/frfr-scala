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
  /** The name of the game character. */
  val name: String

  /** Checks if the character is alive.
   *
   * @return true if the character is alive; false otherwise.
   */
  def isAlive: Boolean

  /** Makes the character attack another game character.
   *
   * @param target the game character that will be attacked.
   */
  def attack(target: GameCharacter): Unit
}

