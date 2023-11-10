package cl.ravenhill.oop.frfr
package model.characters

import observer.AbstractSubject

import cl.ravenhill.oop.frfr.model.CharacterDeathEvent

/**
 * An abstract class that defines the common structure and behavior of game characters.
 * This class is intended to be extended by specific types of characters in a game.
 *
 * @constructor Create a new character with a name and maximum health.
 * @param name      The name of the character.
 * @param maxHealth The maximum health that the character can have.
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 1.0
 * @version 2.0
 */
abstract class AbstractCharacter(override val name: String, override val maxHealth: Int, override val maxMana: Int)
  extends AbstractSubject[CharacterDeathEvent] with GameCharacter {

  protected var _currentHealth: Int = maxHealth
  override def currentHealth_=(value: Int): Unit = _currentHealth = Math.max(Math.min(maxHealth, value), 0)
  override def currentHealth: Int = _currentHealth
  private var _currentMana: Int = maxMana
  override def currentMana: Int = _currentMana
  override def currentMana_=(value: Int): Unit = _currentMana = Math.min(maxMana, value)
  override def attack(target: GameCharacter): Unit = target.currentHealth -= 1
  override def isAlive: Boolean = _currentHealth > 0
}
