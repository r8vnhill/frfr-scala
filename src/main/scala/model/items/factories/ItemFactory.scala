
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Item

trait ItemFactory[T <: Item] {
  var name: Option[String]
  def createItem(): T
}
