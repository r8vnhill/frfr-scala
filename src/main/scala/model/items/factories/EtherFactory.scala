
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Ether

import cl.ravenhill.oop.frfr.exceptions.FactoryConfigurationException

class EtherFactory extends ItemFactory[Ether] {
  override var name: Option[String] = None

  var restore: Option[Int] = None

  private def isReady: Boolean = name.isDefined && restore.isDefined

  override def createItem(): Ether = {
    if (!isReady) {
      throw new FactoryConfigurationException("Factory is not ready: name and restore must be defined.")
    }
    new Ether(name.get, restore.get)
  }
}

