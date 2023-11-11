package cl.ravenhill.oop.frfr
package exceptions

/** A custom exception class for handling configuration errors in factories.
  * This exception is typically thrown when there is an issue with setting up or configuring a factory,
  * such as missing or invalid parameters.
  *
  * Extending the standard `Exception` class, this exception includes a custom message that can be used
  * to provide detailed information about the configuration error.
  *
  * @constructor Creates a new factory configuration exception with a custom message.
  * @param message A string providing details about the configuration error.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2.0
  * @version 2.0
  */
class FactoryConfigurationException(message: String) extends Exception(message)
