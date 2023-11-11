package cl.ravenhill.oop.frfr
package model.items.factories

import exceptions.FactoryConfigurationException
import model.items.Ether

/** A factory class for creating instances of `Ether`, extending the `ItemFactory` abstract class. This class
  * specializes in the creation of `Ether` items, which typically involve restoring mana or similar resources
  * in a game. It demonstrates the Factory design pattern, encapsulating the logic for object creation.
  *
  * The factory allows setting of the item's name and the amount of restoration (typically mana) before creating
  * an [[Ether]] object. The [[isReady]] method checks if the necessary properties ([[name]] and [[restore]]` have been
  * set prior to creation, throwing a [[FactoryConfigurationException]] if any property is missing.
  *
  * @constructor Initializes the factory with no name and restore value set.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2023O
  * @version 2023P
  */
class EtherFactory extends ItemFactory[Ether] {

  /** Optional name for the [[Ether]] item. */
  override var name: Option[String] = None

  /** Optional amount of restoration the [[Ether]] item provides. */
  var restore: Option[Int] = None

  /** Checks if the factory is ready to create an item, i.e., all necessary properties are defined. */
  private def isReady: Boolean = name.isDefined && restore.isDefined

  /** Creates an Ether item. Ensures that the factory is ready (all necessary properties are set) before creation.
    * If the factory is not ready, it throws a [[FactoryConfigurationException]].
    * @return A new Ether item.
    * @throws FactoryConfigurationException if the factory is not ready to create an item.
    */
  override def createItem(): Ether = {
    if (!isReady) {
      throw new FactoryConfigurationException(
        "Factory is not ready: name and restore must be defined."
      )
    }
    new Ether(name.get, restore.get)
  }
}
