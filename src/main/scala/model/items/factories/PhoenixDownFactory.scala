
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.PhoenixDown

import cl.ravenhill.oop.frfr.exceptions.FactoryConfigurationException

/** A specific factory for creating [[PhoenixDown]] items.
 *
 * This factory creates `PhoenixDown` items using the provided name, which can be set after the
 * factory's creation.
 *
 * An exception will be thrown if `name` is not set prior to calling `createItem()`.
 *
 * @constructor Creates a new `PhoenixDownFactory` with an empty name property.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class PhoenixDownFactory extends ItemFactory[PhoenixDown] {

  override var name: Option[String] = None

  var restore: Option[Double] = None

  private def isReady: Boolean = name.isDefined && restore.isDefined

  override def createItem(): PhoenixDown = {
    if (!isReady) {
      throw new FactoryConfigurationException("Factory is not ready: name and restore must be defined.")
    }
    new PhoenixDown(name.get, restore.get)
  }
}
