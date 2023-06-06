package cl.ravenhill.oop.frfr
package view

trait UserInterface {
  def promptSelection(options: List[String]): Int
}
