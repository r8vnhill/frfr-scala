
package cl.ravenhill.oop.frfr
package states

/**
 * Represents the idle state in a game's state machine, extending the `GameState` class. This specific state
 * is used when the game is in a passive mode, waiting for user input or the next action. `IdleState` is a concrete
 * implementation of a game state, providing specific behavior that occurs when the game is in this idle mode.
 *
 * In the context of the State design pattern, `IdleState` demonstrates how a specific state can implement and
 * modify the behavior defined in the `GameState` base class. One of the key functionalities of `IdleState` is
 * the ability to transition to the `SelectingTargetState`.
 *
 * Upon transitioning to `SelectingTargetState`, this state class changes the current state of the game controller
 * to a new instance of `SelectingTargetState` and triggers the selection process by calling `promptSelection` on the
 * game controller. This illustrates how state transitions can lead to different actions and behaviors in the game.
 *
 * @constructor Creates an IdleState and sets it as the current state in the provided GameController context.
 * @param context The GameController that this state is associated with.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class IdleState(context: GameController) extends GameState(context) {

  /**
   * Transitions the game to the `SelectingTargetState`. This method changes the current state of the game controller
   * to `SelectingTargetState` and initiates the target selection process.
   */
  override def toSelectingTargetState(): Unit = {
    context.state = new SelectingTargetState(context)
    context.promptSelection()
  }
}

