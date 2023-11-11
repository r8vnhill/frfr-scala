
package cl.ravenhill.oop.frfr
package events

/**
 * Represents an event signaling the death of a character within the game. This class is used to communicate
 * information about character deaths, specifically distinguishing whether the character is an enemy or a player character.
 *
 * The `isEnemy` flag is essential to determine the type of character that died, enabling different parts of the game
 * logic to respond appropriately. For example, the game might handle scoring, progression, or state changes differently
 * based on whether an enemy or a player character has died.
 *
 * Instances of this class are typically created and dispatched by character classes when their health reaches zero,
 * and are consumed by observers or event handlers responsible for managing game state and logic.
 *
 * @constructor Creates a new character death event.
 * @param isEnemy A boolean flag indicating whether the deceased character is an enemy. `true` if the character is an enemy, `false` otherwise.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023P
 * @version 2023P
 */
class CharacterDeathEvent(val isEnemy: Boolean)
