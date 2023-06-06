
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** Represents a potion in the game that can heal a `GameCharacter`.
 *
 * A `Potion` is a specific type of `Item` that has a healing effect on the character it is used on.
 * The amount of healing it provides is specified at the time of creation and cannot be changed
 * afterward.
 *
 * When a `Potion` is used on a character (by calling the `useOn` method), a message is printed
 * indicating the amount of healing provided and the name of the character it was used on.
 *
 * @constructor Creates a new potion with a given name and healing effect.
 * @param name The name of the potion.
 * @param healing The amount of healing the potion provides when used.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Potion(override val name: String, val healing: Int) extends Item {
  /** Uses this potion on a target `GameCharacter`, healing them by its healing value.
   *
   * When the potion is used, it prints a message to the console indicating the amount of healing
   * and the name of the character it was used on.
   *
   * @param target The `GameCharacter` on which the potion will be used.
   */
  override def useOn(target: GameCharacter): Unit = {
    println(s"Healing $healing HP to ${target.name}")
  }
}
