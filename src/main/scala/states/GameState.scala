package cl.ravenhill.oop.frfr
package states

import exceptions.InvalidTransitionException

/** Represents a state in the game's state machine, providing a base class for different game states.
  * This class forms part of the State design pattern, where it encapsulates the behavior associated
  * with a specific state of the [[GameController]].
  *
  * Upon instantiation, [[GameState]] automatically sets itself as the current state in the provided
  * [[GameController]] context. This class provides a skeletal implementation for game states, including
  * methods for performing actions and transitioning to other states. The specific behaviors and transitions
  * are meant to be defined in subclasses representing concrete states of the game.
  *
  * @constructor Initializes a new game state and sets it as the current state in the provided GameController context.
  * @param context The GameController that this state is associated with.
  *
  * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
  * @since 2023O
  * @version 2023P
  */
class GameState protected (val context: GameController) {
  context.state = this

  /** Performs the action associated with this state. This base implementation does nothing and can be overridden
    * by subclasses to provide state-specific behavior.
    */
  def doAction(): Unit = {
    // Do nothing
  }

  /** Attempts to transition the game to the Idle state. Throws an InvalidTransitionException in this base class.
    * Subclasses may override this to allow the transition.
    */
  def toIdleState(): Unit = transitionError("IdleState")

  /** Attempts to transition the game to the SelectingTargetState. Throws an InvalidTransitionException in this base class.
    * Subclasses may override this to allow the transition.
    */
  def toSelectingTargetState(): Unit = transitionError("SelectingTargetState")

  /** Throws an InvalidTransitionException, indicating that a transition to the specified state is not allowed.
    * @param targetState The name of the state to which the transition was attempted.
    * @throws InvalidTransitionException if the transition is not valid in the current state context.
    */
  private def transitionError(targetState: String): Unit =
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
}
