
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** Represents an item in the game that can be used on a `GameCharacter`.
 *
 * An `Item` in this context is an abstract concept.
 * It could represent a healing potion, a buff, etc.
 *
 * The `Item` trait defines a common interface for all such items.
 * Each item must have a name, and must define a `useOn` method to define what happens when the item
 * is used on a `GameCharacter`.
 *
 * Specific types of items would extend this trait and provide their own implementation of the
 * `useOn` method.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
trait Item {

  /** The name of the item. */
  val name: String

  /** Use this item on a target `GameCharacter`.
   *
   * What exactly happens when an item is used would depend on the specific type of item.
   * For example, a healing potion might increase the health of the character, while a buff might
   * increase the attack power of the character.
   *
   * @param target The `GameCharacter` on which the item will be used.
   */
  def useOn(target: GameCharacter): Unit
}

