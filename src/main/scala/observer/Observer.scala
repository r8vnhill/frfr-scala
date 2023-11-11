package cl.ravenhill.oop.frfr
package observer

/** A trait representing the Observer part of the Observer design pattern. In this pattern, an Observer
  * is an object that wishes to be informed about events or changes in another object, known as the Subject.
  * This trait provides a generic interface for objects that need to observe changes in Subjects.
  *
  * The Observer design pattern is commonly used in scenarios where an object needs to automatically notify
  * a set of dependent objects about its state changes. It is a fundamental pattern for implementing distributed
  * event handling systems, where the subject is the source of events, and observers are the listeners/responders.
  *
  * Implementing this trait requires defining the `update` method, which is invoked when the Subject that this
  * Observer is registered with undergoes a change. The `update` method provides a mechanism for the Subject to
  * send notifications to the Observer, passing along any relevant information about the event or change.
  *
  * @tparam T The type of the value associated with the update notification. This type parameter allows the
  *           Observer to be used in a type-safe manner with different kinds of subjects.
  */
trait Observer[T] {

  /** Called by the Subject that this Observer is registered with whenever a relevant event or state change occurs.
    * This method should define how the Observer responds to the update.
    *
    * @param observable The Subject object that is notifying this Observer of a change or event.
    * @param value The value or information associated with the update, of type `T`.
    */
  def update(observable: Subject[T], value: T): Unit
}
