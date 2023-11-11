package cl.ravenhill.oop.frfr
package model.items

import exceptions.{InvalidItemUseException, InvalidStatException}
import model.characters.GameCharacter

/** Represents a `PhoenixDown` item in a game, extending the `Item` class. PhoenixDown is typically used for
  * reviving or significantly healing non-living characters in a game. This class encapsulates the properties
  * and behavior specific to PhoenixDown items.
  *
  * The `PhoenixDown` item holds a `restore` value indicating the fraction of maximum health it can restore to a
  * character. It must be within the range [0, 1]. An `InvalidStatException` is thrown if the restore value is outside
  * this range, ensuring the value is valid and within expected limits.
  *
  * The `useOn` method defines the action of using the PhoenixDown on a target `GameCharacter`. It throws an
  * `InvalidItemUseException` if the target character is alive, as PhoenixDown is designed to be used on characters
  * that are not alive. When used on a non-living character, it restores a portion of the character's maximum health
  * based on the `restore` value.
  *
  * @constructor Initializes a new PhoenixDown item with a name and a restore value. Validates the restore value.
  * @param name The name of the PhoenixDown item.
  * @param restore The fraction of max health this PhoenixDown item can restore, must be between 0 and 1.
  * @throws InvalidStatException if the restore value is not within the range [0, 1].
  */
class PhoenixDown(override val name: String, val restore: Double) extends Item {
  if (restore < 0 || restore > 1) {
    throw new InvalidStatException(
      "Phoenix Down restore value must be between 0 and 1."
    )
  }

  /** Uses this PhoenixDown item on a specified target game character.
    * Restores a portion of the character's maximum health if they are not alive. Throws an exception if
    * the target character is alive.
    *
    * @param target The `GameCharacter` on whom the PhoenixDown is to be used.
    * @throws InvalidItemUseException if the PhoenixDown is used on a living character.
    */
  override def useOn(target: GameCharacter): Unit = {
    if (target.isAlive)
      throw new InvalidItemUseException(
        "Phoenix Down cannot be used on a living character."
      )
    target.currentHealth = (target.maxHealth * restore).toInt
  }
}
