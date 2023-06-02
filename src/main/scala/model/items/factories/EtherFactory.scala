
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Ether

class EtherFactory extends ItemFactory[Ether] {
  override var name: Option[String] = None
  var restore: Option[Int] = None

  def createItem(): Ether = {
    new Ether(name.get, restore.get)
  }
}
