
package cl.ravenhill.oop.frfr
package model.characters

import model.CharacterDeathEvent

/** Represents an enemy game character.
 *
 * This is a concrete implementation of the [[AbstractCharacter]] class, representing enemies that
 * the player may encounter in the game.
 *
 * @constructor Creates a new enemy character with a given name.
 * @param name The name of the enemy character.
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class EnemyCharacter(name: String, maxHealth: Int, maxMana: Int) extends AbstractCharacter(name, maxHealth, maxMana) {
  override def currentHealth_=(value: Int): Unit = {
    _currentHealth = Math.min(maxHealth, value)
    if (!isAlive) {
      notifyObservers(new CharacterDeathEvent(isEnemy = true))
    }
  }
}
