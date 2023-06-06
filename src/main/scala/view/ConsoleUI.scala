
package cl.ravenhill.oop.frfr
package view

class ConsoleUI extends UserInterface {
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
