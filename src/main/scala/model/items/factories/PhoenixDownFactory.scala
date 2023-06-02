
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.PhoenixDown

class PhoenixDownFactory extends ItemFactory[PhoenixDown] {
  override var name: Option[String] = None

  def createItem(): PhoenixDown = {
    new PhoenixDown(name.get)
  }
}
