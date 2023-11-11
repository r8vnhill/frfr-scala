package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** Represents an `Ether` item in a game, extending the `Item` class. `Ether` is typically used for restoring
  * a certain amount of mana (or a similar resource) to a game character. This class encapsulates the properties
  * and behavior specific to Ether items.
  *
  * The `Ether` item holds a `restore` value indicating the amount of mana it can replenish when used on a character.
  * The `useOn` method defines the action of using the Ether on a target `GameCharacter`, which involves increasing
  * the target's current mana by the `restore` value.
  *
  * @constructor Initializes a new Ether item with a name and a restore value.
  * @param name The name of the Ether item.
  * @param restore The amount of mana this Ether item can restore.
  */
class Ether(override val name: String, val restore: Int) extends Item {

  /** Uses this Ether item on a specified target game character.
    * Increases the character's current mana by this item's restore value.
    *
    * @param target The `GameCharacter` on whom the Ether is to be used.
    */
  override def useOn(target: GameCharacter): Unit =
    target.currentMana += restore
}
