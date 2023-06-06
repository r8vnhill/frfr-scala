
package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Potion

/** A specific factory for creating [[Potion]] items.
 *
 * This factory creates `Potion` items using the provided name and healing effect,
 * both of which can be set after the factory's creation.
 *
 * An exception will be thrown if either `name` or `healing` are not set prior to
 * calling `createItem()`.
 *
 * @constructor Creates a new `PotionFactory` with empty name and healing properties.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class PotionFactory extends ItemFactory[Potion] {
  /// Documentation inherited from [[ItemFactory]]
  override var name: Option[String] = None

  /** An optional healing effect for the `Potion` to be created.
   *
   * This healing effect can be set after the factory's creation and will be used when creating
   * a new `Potion` with `createItem()`.
   */
  var healing: Option[Int] = None

  /** Creates a new `Potion` with the specified name and healing effect.
   *
   * @return A new `Potion` with the given name and healing effect.
   * @throws NoSuchElementException If `name` or `healing` is not set.
   */
  override def createItem(): Potion = {
    new Potion(name.get, healing.get)
  }
}
