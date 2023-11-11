
package cl.ravenhill.oop.frfr
package model.characters

import events.CharacterDeathEvent

/**
 * Represents a player character in the game, extending the `AbstractCharacter` class. This class is tailored
 * specifically for characters controlled by players, with custom behavior for health management and death event handling.
 *
 * Similar to `EnemyCharacter`, when the health of a `PlayerCharacter` is updated and it results in death,
 * a `CharacterDeathEvent` is notified to all observers. However, in this case, the event signifies the death of a
 * player-controlled character. This is crucial for game mechanics that depend on player character states, such as
 * determining game over conditions or triggering specific game events.
 *
 * @constructor Initializes a new player character with a name, maximum health, and maximum mana.
 * @param name The name of the player character.
 * @param maxHealth The maximum health points the player character can have.
 * @param maxMana The maximum mana points the player character can have.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class PlayerCharacter(name: String, maxHealth: Int, maxMana: Int) extends AbstractCharacter(name, maxHealth, maxMana) {

  /**
   * Setter for current health. Overrides the method in `AbstractCharacter` to ensure that when the health
   * of the player character drops to zero or below, a `CharacterDeathEvent` is triggered to notify all observers.
   * The health value is maintained within the range [0, maxHealth].
   *
   * @param value The new health value to be set.
   */
  override def currentHealth_=(value: Int): Unit = {
    _currentHealth = Math.max(Math.min(maxHealth, value), 0)
    if (!isAlive) {
      notifyObservers(new CharacterDeathEvent(isEnemy = false))
    }
  }
}
