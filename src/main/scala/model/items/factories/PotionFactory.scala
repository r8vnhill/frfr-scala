
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Potion

import cl.ravenhill.oop.frfr.exceptions.FactoryConfigurationException

class PotionFactory extends ItemFactory[Potion] {

  var name: Option[String] = None

  var healing: Option[Int] = None

  private def isReady: Boolean = name.isDefined && healing.isDefined

  override def createItem(): Potion = {
    if (!isReady) {
      throw new FactoryConfigurationException("Factory is not ready: name and healing must be defined.")
    }
    new Potion(name.get, healing.get)
  }
}
