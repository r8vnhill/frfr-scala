package cl.ravenhill.oop.frfr
package view

/** A trait representing a user interface for the game.
 *
 * `UserInterface` defines an abstract method, `promptSelection`, which is designed to interact with
 * the user and collect their selection from a given list of options.
 *
 * Concrete classes implementing this trait should provide their own implementation of the
 * `promptSelection` method, allowing the game to be played through different types of user
 * interfaces (e.g., command-line, graphical, web-based, etc.).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
trait UserInterface {
  /** Prompts the user to make a selection from a given list of options.
   *
   * Implementing classes should provide a method that presents the options to the user and
   * collects their choice, returning the index of the selected option.
   *
   * @param options A list of strings representing the available options for selection.
   * @return The index of the user's selected option in the list.
   */
  def promptSelection(options: List[String]): Int
}
