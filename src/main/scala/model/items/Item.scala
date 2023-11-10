
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

trait Item {

  val name: String

  def useOn(target: GameCharacter): Unit
}

