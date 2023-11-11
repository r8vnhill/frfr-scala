
package cl.ravenhill.oop.frfr
package exceptions

/**
 * A custom exception class designed to signal illegal or invalid state transitions within the game.
 * This exception is particularly useful in contexts where game elements or characters are required to
 * transition between various states, and an attempted transition is either prohibited or does not make
 * sense within the game's rules or logic. An example could be attempting to move a character to a
 * battle state when they are already in a non-compatible state.
 *
 * By extending the standard `Exception` class, `InvalidTransitionException` encapsulates a descriptive
 * message explaining the reason for the exception. This message is instrumental in debugging and clarifying
 * the nature of the invalid transition to developers or players.
 *
 * @constructor Creates a new exception instance to indicate an invalid or illegal state transition.
 * @param message A detailed description of the invalid transition scenario.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2.0
 * @version 2.0
 */
class InvalidTransitionException(message: String) extends Exception(message)
