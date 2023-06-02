package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

class Ether(override val name: String, val restore: Int) extends Item {
  override def useOn(target: GameCharacter): Unit = {
    println(s"Restoring $restore MP to ${target.name}")
  }
}
