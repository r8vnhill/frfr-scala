package cl.ravenhill.oop.frfr
package model.characters

/**
 * An abstract class that defines the common structure and behavior of game characters.
 * This class is intended to be extended by specific types of characters in a game.
 *
 * @constructor Create a new character with a name and maximum health.
 * @param name The name of the character.
 * @param maxHealth The maximum health that the character can have.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 1.0
 * @version 2.0
 */
abstract class AbstractCharacter protected(override val name: String, override val maxHealth: Int)
  extends GameCharacter {

  // Private variable to hold the current health of the character.
  private var _currentHealth: Int = maxHealth

  /**
   * Accessor for the current health of the character.
   * @return The current health of the character.
   */
  override def currentHealth: Int = _currentHealth

  /**
   * Mutator for the current health of the character.
   * Ensures that the health does not exceed the maximum health.
   * @param value The new health value to be set.
   */
  override def currentHealth_=(value: Int): Unit =
    _currentHealth = Math.min(maxHealth, value)

  /**
   * Method to perform an attack on a target character.
   * Reduces the target's current health by 1.
   * @param target The character to be attacked.
   */
  override def attack(target: GameCharacter): Unit =
    target.currentHealth -= 1

  /**
   * Method to check if the character is alive.
   * A character is considered alive if its current health is greater than 0.
   * @return True if the character is alive, False otherwise.
   */
  override def isAlive: Boolean = _currentHealth > 0
}
