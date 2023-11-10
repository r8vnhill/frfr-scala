
package cl.ravenhill.oop.frfr
package observer

trait Observer[T] {
  def update(observable: Subject[T], value: T): Unit
}
