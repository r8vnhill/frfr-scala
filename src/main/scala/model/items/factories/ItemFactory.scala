
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Item

/** Represents a factory for creating items in the game.
 *
 * The `ItemFactory` is a parametrized trait with a type parameter `T` that extends `Item`. This
 * means the factory can be used to create any kind of game item, depending on the specific
 * implementation.
 *
 * Implementations of this trait should provide a definition for the `createItem` method, which
 * should create a new instance of the specified item type.
 *
 * @tparam T The specific type of `Item` that this factory creates.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
trait ItemFactory[T <: Item] {
  /** An optional name for the item to be created.
   *
   * This value can be used by implementations of `createItem` to set the name of the created item.
   * The fact that it's an `Option` allows for the name to be set after the factory's creation,
   * making it flexible for scenarios where the item's name isn't known at the time of the
   * factory's instantiation.
   */
  var name: Option[String]

  /** Creates a new instance of the item type `T`.
   *
   * Implementations of this method should create a new instance of `T`, possibly using the
   * `name` property to set the item's name.
   *
   * @return A new instance of the item type `T`.
   */
  def createItem(): T
}
