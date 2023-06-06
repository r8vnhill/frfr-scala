
package cl.ravenhill.oop.frfr
package states

/** Represents the idle state in the game, as part of the State Design Pattern implementation.
 *
 * In the `IdleState`, the game is not waiting for any input from the player.
 * It provides a specific implementation of the [[GameState]] for when the game is idle.
 *
 * The `context` parameter is used to transition between states, specifically, to
 * `SelectingTargetState` when the game needs to wait for the player's input.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new idle game state with a given context.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class IdleState(context: GameController) extends GameState(context) {

  /** Transition the game state from [[IdleState]] to [[SelectingTargetState]].
   *
   * This method changes the game state to `SelectingTargetState` and prompts the player for
   * selection via the `context`.
   */
  override def toSelectingTargetState(): Unit = {
    context.state = new SelectingTargetState(context)
    context.promptSelection()
  }
}
