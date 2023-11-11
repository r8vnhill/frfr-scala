
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Potion

import cl.ravenhill.oop.frfr.exceptions.FactoryConfigurationException

/**
 * A factory class for creating instances of `Potion`, extending the `ItemFactory` abstract class. This class
 * specializes in the creation of `Potion` items, which are commonly used in games for health restoration or similar
 * effects. It implements the Factory design pattern, encapsulating the logic for creating Potion objects.
 *
 * This factory requires both the item's name and the healing amount to be defined before a `Potion` can be created.
 * The `isReady` method is used to check if these necessary properties (`name` and `healing`) are set,
 * ensuring that the factory is properly configured before proceeding with item creation. If any of these properties
 * are not set, a `FactoryConfigurationException` is thrown.
 *
 * The class demonstrates effective use of Scala's Option type for handling optional parameters, and highlights
 * the importance of proper validation in the object creation process.
 *
 * @constructor Initializes the factory with no name and healing value set.
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class PotionFactory extends ItemFactory[Potion] {

  /** Optional name for the `Potion` item. */
  var name: Option[String] = None

  /** Optional healing amount the `Potion` provides, represented as an Int. */
  var healing: Option[Int] = None

  /**
   * Checks if the factory is ready to create a `Potion`, i.e., both name and healing are defined.
   * @return Boolean indicating whether the factory is ready to create an item.
   */
  private def isReady: Boolean = name.isDefined && healing.isDefined

  /**
   * Creates a `Potion` item. This method ensures that the factory is ready with all necessary properties set before
   * proceeding with the creation. If the factory is not ready, it throws a `FactoryConfigurationException`.
   * @return A new `Potion` item.
   * @throws FactoryConfigurationException if the factory is not ready to create an item.
   */
  override def createItem(): Potion = {
    if (!isReady) {
      throw new FactoryConfigurationException(
        "Factory is not ready: name and healing must be defined."
      )
    }
    new Potion(name.get, healing.get)
  }
}

