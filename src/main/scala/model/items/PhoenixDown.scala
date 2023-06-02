
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

class PhoenixDown(override val name: String) extends Item {
  override def useOn(target: GameCharacter): Unit = {
    if (!target.isAlive) {
      println(s"Reviving ${target.name}")
    } else {
      println(s"${target.name} is already alive")
    }
  }
}
