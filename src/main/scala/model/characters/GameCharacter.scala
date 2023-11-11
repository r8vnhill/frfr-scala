package cl.ravenhill.oop.frfr
package model.characters

/**
 * A trait defining the essential attributes and behaviors of game characters. This trait is intended
 * to be mixed into concrete classes that represent specific characters in a game, both player-controlled
 * and non-player characters (NPCs). It provides a common interface for character-related operations.
 *
 * Implementing this trait ensures that a character has a name, maximum health and mana points, and
 * methods to manage their current health and mana. Additionally, it defines the fundamental behaviors
 * like checking if the character is alive and the ability to perform an attack on another character.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
trait GameCharacter {
  /** The name of the game character. */
  val name: String

  /** The maximum health points a character can have. */
  val maxHealth: Int

  /** Getter for current health points of the character. */
  def currentHealth: Int

  /** Setter for current health points of the character. */
  def currentHealth_=(value: Int): Unit

  /** The maximum mana points a character can have. */
  val maxMana: Int

  /** Getter for current mana points of the character. */
  def currentMana: Int

  /** Setter for current mana points of the character. */
  def currentMana_=(value: Int): Unit

  /** Checks if the character is still alive. */
  def isAlive: Boolean

  /**
   * Method for a character to perform an attack on another character.
   * @param target The `GameCharacter` instance that is the target of the attack.
   */
  def attack(target: GameCharacter): Unit
}