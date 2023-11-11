package cl.ravenhill.oop.frfr
package exceptions

/** A custom exception class used for signaling invalid use of items within the game.
  * This exception is typically thrown when a game item is used in an inappropriate context,
  * such as using a healing item on a character who is not injured or using a specific item in a wrong situation.
  *
  * This class extends the standard `Exception` class, enabling it to carry a custom message
  * that describes the specific reason for the exception. This message can be used to inform the user
  * or the developer about the nature of the invalid item use, facilitating debugging and user feedback.
  *
  * @constructor Creates a new exception to indicate invalid item usage.
  * @param message A descriptive message explaining the reason for the exception.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2.0
  * @version 2.0
  */
class InvalidItemUseException(message: String) extends Exception(message)
