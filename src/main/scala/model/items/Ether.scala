package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** Represents an Ether in the game that can restore a `GameCharacter`'s mana points (MP).
 *
 * An `Ether` is a specific type of `Item` that has a mana restoration effect on the character it
 * is used on. The amount of mana restoration it provides is specified at the time of creation and
 * cannot be changed afterward.
 *
 * When an `Ether` is used on a character (by calling the `useOn` method), a message is printed
 * indicating the amount of mana restoration and the name of the character it was used on.
 *
 * @constructor Creates a new ether with a given name and mana restoration effect.
 * @param name The name of the ether.
 * @param restore The amount of mana restoration the ether provides when used.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class Ether(override val name: String, val restore: Int) extends Item {
  /** Uses this ether on a target `GameCharacter`, restoring their mana by its restore value.
   *
   * When the ether is used, it prints a message to the console indicating the amount of mana
   * restoration and the name of the character it was used on.
   *
   * @param target The `GameCharacter` on which the ether will be used.
   */
  override def useOn(target: GameCharacter): Unit = {
    println(s"Restoring $restore MP to ${target.name}")
  }
}

