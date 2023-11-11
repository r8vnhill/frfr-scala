package cl.ravenhill.oop.frfr
package model.items.factories

import model.items.Item

/** A trait representing a factory for creating items in a game, demonstrating the use of generics with variance in Scala.
  * The `+T <: Item` notation signifies that `ItemFactory` is covariant in `T`. This means if `X` is a subtype of `Y`,
  * then `ItemFactory[X]` is considered a subtype of `ItemFactory[Y]`. This covariance is suitable here since the factory
  * only produces (or 'gets') items, aligning with the 'get' part of the get-put principle.
  *
  * The get-put principle in Scala guides the use of variance annotations. It states that for a producer (or 'getter')
  * which only produces objects of a certain type (like this factory), covariant type parameters (`+T`) are appropriate.
  * On the other hand, contravariant type parameters (`-T`) are suited for consumers (or 'putters') which only consume
  * or accept objects of a certain type.
  *
  * In this trait, the factory produces objects of type `T`, which extends `Item`, making `T` covariant. However, if
  * the trait were to also accept items of type `T` (e.g., in a method parameter), it would need to be contravariant
  * or invariant in `T` depending on the usage.
  *
  * @tparam T The type of item produced by this factory. It must be a subtype of `Item`. Covariant in `T`.
  *
  * @constructor Creates an `ItemFactory` instance.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2023O
  * @version 2023P
  */
trait ItemFactory[+T <: Item] {

  /** Optional name for the item to be created. */
  var name: Option[String]

  /** Creates and returns a new item of type `T`.
    * @return A new instance of type `T`.
    */
  def createItem(): T
}
