
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Ether

/** A specific factory for creating [[Ether]] items.
 *
 * This factory creates `Ether` items using the provided name and mana restoration amount,
 * both of which can be set after the factory's creation.
 *
 * An exception will be thrown if either `name` or `restore` are not set prior to
 * calling `createItem()`.
 *
 * @constructor Creates a new `EtherFactory` with empty name and restore properties.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class EtherFactory extends ItemFactory[Ether] {
  /// Documentation inherited from [[ItemFactory]]
  override var name: Option[String] = None

  /** An optional mana restoration effect for the `Ether` to be created.
   *
   * This restore effect can be set after the factory's creation and will be used when creating
   * a new `Ether` with `createItem()`.
   */
  var restore: Option[Int] = None

  /** Creates a new `Ether` with the specified name and mana restoration effect.
   *
   * @return A new `Ether` with the given name and mana restoration effect.
   * @throws NoSuchElementException If `name` or `restore` is not set.
   */
  override def createItem(): Ether = {
    new Ether(name.get, restore.get)
  }
}

