package cl.ravenhill.oop.frfr
package model.characters

import observer.AbstractSubject
import cl.ravenhill.oop.frfr.events.CharacterDeathEvent

/**
 * An abstract class representing a character in the game, encompassing common attributes and functionalities
 * shared among different types of characters. This class serves as a foundation for specific character types
 * and demonstrates the use of abstraction in object-oriented design.
 *
 * `AbstractCharacter` extends `AbstractSubject` to incorporate event notification capabilities, particularly
 * for `CharacterDeathEvent`, and implements the `GameCharacter` interface, ensuring that all essential
 * character-related methods are present.
 *
 * @constructor Initializes a new character with specified name, maximum health, and maximum mana.
 * @param name The name of the character.
 * @param maxHealth The maximum health points the character can have.
 * @param maxMana The maximum mana points the character can have.
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
abstract class AbstractCharacter(override val name: String, override val maxHealth: Int, override val maxMana: Int)
  extends AbstractSubject[CharacterDeathEvent] with GameCharacter {

  /** Internal state for current health, initialized to maxHealth. */
  protected var _currentHealth: Int = maxHealth

  /**
   * Setter for current health. Ensures the health value is within the valid range [0, maxHealth].
   * @param value The new health value to be set.
   */
  override def currentHealth_=(value: Int): Unit = _currentHealth = Math.max(Math.min(maxHealth, value), 0)

  /** Getter for current health. */
  override def currentHealth: Int = _currentHealth

  /** Internal state for current mana, initialized to maxMana. */
  private var _currentMana: Int = maxMana

  /** Getter for current mana. */
  override def currentMana: Int = _currentMana

  /**
   * Setter for current mana. Ensures the mana value does not exceed maxMana.
   * @param value The new mana value to be set.
   */
  override def currentMana_=(value: Int): Unit = _currentMana = Math.min(maxMana, value)

  /**
   * Implementation of the attack method. Reduces the target's current health by 1.
   * @param target The character being attacked.
   */
  override def attack(target: GameCharacter): Unit = target.currentHealth -= 1

  /** Checks if the character is still alive, based on their current health. */
  override def isAlive: Boolean = _currentHealth > 0
}

