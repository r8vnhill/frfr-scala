
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.PhoenixDown

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
  /// Documentation inherited from [[ItemFactory]]
  override var name: Option[String] = None

  /** Creates a new `PhoenixDown` with the specified name.
   *
   * @return A new `PhoenixDown` with the given name.
   * @throws NoSuchElementException If `name` is not set.
   */
  override def createItem(): PhoenixDown = {
    new PhoenixDown(name.get)
  }
}
