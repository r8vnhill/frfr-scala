
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** Represents a Phoenix Down in the game that can revive a dead `GameCharacter`.
 *
 * A `PhoenixDown` is a specific type of `Item` that has a revival effect on the character it is
 * used on, if the character is not already alive.
 *
 * When a `PhoenixDown` is used on a character (by calling the `useOn` method), if the character
 * is dead, a message is printed indicating the character's revival. If the character is already
 * alive, a different message is printed.
 *
 * @constructor Creates a new Phoenix Down with a given name.
 * @param name The name of the Phoenix Down.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class PhoenixDown(override val name: String) extends Item {
  /** Uses this Phoenix Down on a target `GameCharacter`, reviving them if they are dead.
   *
   * When the Phoenix Down is used, if the target character is dead, it prints a message to the
   * console indicating the character's revival. If the character is already alive, it prints
   * a different message.
   *
   * @param target The `GameCharacter` on which the Phoenix Down will be used.
   */
  override def useOn(target: GameCharacter): Unit = {
    if (!target.isAlive) {
      println(s"Reviving ${target.name}")
    } else {
      println(s"${target.name} is already alive")
    }
  }
}

