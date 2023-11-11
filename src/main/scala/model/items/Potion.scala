
package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/**
 * Represents a `Potion` item in a game, extending the `Item` class. A Potion is typically used for healing
 * game characters, restoring a specified amount of health. This class encapsulates the properties and behavior
 * specific to Potion items.
 *
 * The `Potion` item holds a `healing` value, indicating the amount of health it can restore to a game character.
 * The `useOn` method defines the action of using the Potion on a target `GameCharacter`, which involves increasing
 * the target's current health by the `healing` value.
 *
 * This class provides a straightforward example of how items can interact with game characters, demonstrating
 * basic game mechanics and object-oriented principles in game development.
 *
 * @constructor Initializes a new Potion item with a name and a healing value.
 * @param name The name of the Potion item.
 * @param healing The amount of health this Potion item can restore.
 */
class Potion(override val name: String, val healing: Int) extends Item {

  /**
   * Uses this Potion item on a specified target game character.
   * Increases the character's current health by this item's healing value.
   *
   * @param target The `GameCharacter` on whom the Potion is to be used.
   */
  override def useOn(target: GameCharacter): Unit = target.currentHealth += healing
}

