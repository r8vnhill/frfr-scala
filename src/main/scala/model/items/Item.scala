package cl.ravenhill.oop.frfr
package model.items

import model.characters.GameCharacter

/** A trait defining the basic structure and behavior of items in a game. This trait serves as a common interface
  * for all items, ensuring a consistent set of functionalities that must be implemented by any concrete item class.
  *
  * Implementing the `Item` trait requires defining the item's name and the behavior when the item is used on a
  * game character. This approach allows different types of items to be handled polymorphically within the game logic,
  * providing flexibility and extensibility in the design of the game's items.
  *
  * Concrete classes that extend this trait are expected to provide specific implementations for the `useOn` method,
  * defining how each item affects the target `GameCharacter`. This could include actions like restoring health or mana,
  * applying a status effect, or any other game-specific interaction.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2023O
  * @version 2023P
  */
trait Item {

  /** The name of the item. */
  val name: String

  /** Defines the action to be taken when this item is used on a target game character.
    * The specific behavior is to be implemented by concrete item classes.
    *
    * @param target The `GameCharacter` on whom the item is to be used.
    */
  def useOn(target: GameCharacter): Unit
}
