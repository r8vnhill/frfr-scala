
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.PhoenixDown

import cl.ravenhill.oop.frfr.exceptions.FactoryConfigurationException

/**
 * A factory class for creating instances of `PhoenixDown`, extending the `ItemFactory` abstract class. This class
 * specializes in the creation of `PhoenixDown` items, which are typically used in games for reviving characters or
 * similar mechanics. It demonstrates the Factory design pattern, encapsulating the logic for object creation.
 *
 * The factory requires setting the item's name and the amount of restoration (typically for reviving characters)
 * before creating a `PhoenixDown` object. The `isReady` method checks whether the necessary properties (`name` and
 * `restore`) have been set prior to creation. If any property is missing, a `FactoryConfigurationException` is thrown.
 *
 * This class highlights the use of Option types for optional parameters and the importance of validation
 * before proceeding with object creation, ensuring that all necessary data is present and correctly configured.
 *
 * @constructor Initializes the factory with no name and restore value set.
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class PhoenixDownFactory extends ItemFactory[PhoenixDown] {

  /** Optional name for the `PhoenixDown` item. */
  override var name: Option[String] = None

  /** Optional amount of restoration the `PhoenixDown` item provides, represented as a Double. */
  var restore: Option[Double] = None

  /**
   * Checks if the factory is ready to create an item, i.e., all necessary properties (name and restore) are defined.
   * @return Boolean indicating whether the factory is ready to create an item.
   */
  private def isReady: Boolean = name.isDefined && restore.isDefined

  /**
   * Creates a `PhoenixDown` item. Ensures that the factory is ready (all necessary properties are set) before creation.
   * If the factory is not ready, it throws a `FactoryConfigurationException`.
   * @return A new `PhoenixDown` item.
   * @throws FactoryConfigurationException if the factory is not ready to create an item.
   */
  override def createItem(): PhoenixDown = {
    if (!isReady) {
      throw new FactoryConfigurationException(
        "Factory is not ready: name and restore must be defined."
      )
    }
    new PhoenixDown(name.get, restore.get)
  }
}

