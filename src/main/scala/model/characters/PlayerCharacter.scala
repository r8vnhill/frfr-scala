
package cl.ravenhill.oop.frfr
package model.characters

import model.CharacterDeathEvent

class PlayerCharacter(name: String, maxHealth: Int, maxMana: Int) extends AbstractCharacter(name, maxHealth, maxMana) {
  override def currentHealth_=(value: Int): Unit = {
    _currentHealth = Math.min(maxHealth, value)
    if (!isAlive) {
      notifyObservers(new CharacterDeathEvent(isEnemy = false))
    }
  }
}
