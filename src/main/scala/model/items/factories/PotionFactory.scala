
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Potion

class PotionFactory extends ItemFactory[Potion] {
  override var name: Option[String] = None
  var healing: Option[Int] = None

  def createItem(): Potion = {
    new Potion(name.get, healing.get)
  }
}
