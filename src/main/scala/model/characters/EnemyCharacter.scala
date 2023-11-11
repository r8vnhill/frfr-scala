
package cl.ravenhill.oop.frfr
package model.characters

import events.CharacterDeathEvent

/**
 * Represents an enemy character in the game, extending the `AbstractCharacter` class. This class specializes
 * the behavior of `AbstractCharacter` for enemy characters, particularly in how their health is managed
 * and how death events are handled.
 *
 * When the health of an `EnemyCharacter` is updated and it results in the character's death,
 * a `CharacterDeathEvent` is notified to all observers, indicating that an enemy character has died.
 * This feature is crucial in the game's mechanics, especially for triggering reactions or changes in the game state
 * when an enemy character is defeated.
 *
 * @constructor Initializes a new enemy character with a name, maximum health, and maximum mana.
 * @param name The name of the enemy character.
 * @param maxHealth The maximum health points the enemy character can have.
 * @param maxMana The maximum mana points the enemy character can have.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class EnemyCharacter(name: String, maxHealth: Int, maxMana: Int) extends AbstractCharacter(name, maxHealth, maxMana) {

  /**
   * Setter for current health. Overrides the method in `AbstractCharacter` to ensure that when the health
   * of the enemy character drops to zero or below, a `CharacterDeathEvent` is triggered to notify all observers.
   * The health value is constrained within the range [0, maxHealth].
   *
   * @param value The new health value to be set.
   */
  override def currentHealth_=(value: Int): Unit = {
    _currentHealth = Math.max(Math.min(maxHealth, value), 0)
    if (!isAlive) {
      notifyObservers(new CharacterDeathEvent(isEnemy = true))
    }
  }
}
