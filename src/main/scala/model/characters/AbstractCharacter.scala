package cl.ravenhill.oop.frfr
package model.characters

/** Abstract base class for a game character.
  *
  * This class provides a basic implementation of the [[GameCharacter]] trait.
  *
  * @constructor Creates a new game character with a given name.
  *              The primary constructor is protected, so this class can only be extended.
  *              This is done since this class is abstract and cannot be instantiated, so it
  *              doesn't make sense to have a public constructor.
  * @param name The name of the game character.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  * @since 1.0
  * @version 1.0
  */
abstract class AbstractCharacter protected (override val name: String)
    extends GameCharacter {
  /// Documentation inherited from [[GameCharacter]]
  override def attack(target: GameCharacter): Unit = {
    println(s"$name attacks ${target.name}")
  }

  //noinspection NotImplementedCode
  /// Documentation inherited from [[GameCharacter]]
  override def isAlive: Boolean = ???
}
