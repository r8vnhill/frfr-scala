
package cl.ravenhill.oop.frfr
package exceptions

/**
 * A custom exception class for indicating errors related to invalid or inappropriate game statistics.
 * This exception is typically thrown in scenarios where game-related statistical values, such as health points,
 * mana points, or other character attributes, are assigned or modified in ways that are not allowed or do not make sense
 * within the game's logic. For example, setting a character's health to a negative number might trigger this exception.
 *
 * Extending the standard `Exception` class, `InvalidStatException` includes a custom message
 * that provides detailed information about the specific statistical error encountered. This message
 * is particularly useful for debugging and for providing clear feedback to developers or players about what went wrong.
 *
 * @constructor Creates a new exception instance to signal an error with game statistics.
 * @param message A string containing a detailed description of the invalid statistic situation.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2.0
 * @version 2.0
 */
class InvalidStatException(message: String) extends Exception(message)
