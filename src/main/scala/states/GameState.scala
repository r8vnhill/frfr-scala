package cl.ravenhill.oop.frfr
package states

/** Represents a state in the game, as a part of the State Design Pattern implementation.
 *
 * This class is a complete, yet fundamental representation of a game state.
 * It provides a default behaviour for a state within the game, and should be extended
 * by other more specific states.
 * The `context` parameter is used to transition between states.
 *
 * The constructor is protected, which prevents direct instantiation of this class, but allows
 * its use as a base class for other game states.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new game state with a given context.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
//noinspection AccessorLikeMethodIsUnit
class GameState protected(val context: GameController) {
  // Set the state of the context to this state
  context.state = this

  /** Transition the game state to [[IdleState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toIdleState(): Unit = {
    transitionError("IdleState")
  }

  /** Transition the game state to [[SelectingTargetState]].
   *
   * This method should be overridden by subclasses that allow this transition.
   *
   * @throws InvalidTransitionException when an invalid state transition is attempted.
   */
  def toSelectingTargetState(): Unit = {
    transitionError("SelectingTargetState")
  }

  /** Performs the action associated with the current state.
   *
   * The base implementation does nothing, and this method should be overridden by
   * subclasses to provide the appropriate behavior.
   */
  def doAction(): Unit = {
    // do nothing
  }

  /** Throws an [[InvalidTransitionException]] with a message about an invalid transition.
   *
   * Notice that this uses [[getClass]] to print the name of the current class.
   * This is one of the few use cases of [[getClass]] that is not considered bad practice, since it
   * is used to print the name of the current class, and not to check the type of an object.
   *
   * @param targetState The name of the state that was attempted to transition to.
   * @throws InvalidTransitionException always.
   */
  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}
