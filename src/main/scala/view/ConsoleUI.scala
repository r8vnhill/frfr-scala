
package cl.ravenhill.oop.frfr
package view

/** Represents a console-based user interface for the game.
 *
 * `ConsoleUI` is a concrete implementation of the [[UserInterface]] trait that uses the standard
 * console (stdin/stdout) for user interaction.
 * It provides an implementation for the `promptSelection` method which displays the options on the
 * console and reads the user's selection from the console input.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class ConsoleUI extends UserInterface {
  /** Prompts the user to make a selection from a given list of options via the console.
   *
   * This method presents the options to the user on the console, numbered starting from 1.
   * It then reads the user's selection from the console input.
   * If the selection is not a valid option (i.e., if it's less than 1 or greater than the number
   * of options), the method informs the user of the invalid selection and prompts again.
   *
   * @param options A list of strings representing the available options for selection.
   * @return The index (1-based) of the user's selected option in the list.
   */
  override def promptSelection(options: List[String]): Int = {
    println("Select an option:")
    for (i <- options.indices) {
      println(s"${i + 1}. ${options(i)}")
    }
    val selection = scala.io.StdIn.readInt()
    if (selection < 1 || selection > options.length) {
      println("Invalid selection")
      promptSelection(options)
    } else {
      selection
    }
  }
}
