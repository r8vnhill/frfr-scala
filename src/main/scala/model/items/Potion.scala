
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

class Potion(override val name: String, val healing: Int) extends Item {

  override def useOn(target: GameCharacter): Unit = target.currentHealth += healing
}
