
package cl.ravenhill.oop.frfr
package states

/** Represents the selecting target state in the game, as part of the State Design Pattern
 * implementation.
 *
 * In the `SelectingTargetState`, the game is waiting for the player's input to select a target for
 * an attack.
 * It provides a specific implementation of the [[GameState]] for when the game is awaiting the
 * player's selection.
 *
 * The `context` parameter is used to transition between states, specifically, back to `IdleState`
 * when the player's selection has been made.
 *
 * @param context The [[GameController]] which controls state transitions.
 * @constructor Creates a new selecting target game state with a given context.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @since 1.0
 * @version 1.0
 */
class SelectingTargetState(context: GameController) extends GameState(context) {

  /** Transition the game state from [[SelectingTargetState]] to [[IdleState]].
   *
   * This method changes the game state to `IdleState` via the `context`.
   */
  override def toIdleState(): Unit = {
    context.state = new IdleState(context)
  }

  /** Performs the action associated with the `SelectingTargetState`, which is to initiate an
   * attack.
   *
   * This method calls the `doAttack` method of the `context` to perform the attack.
   */
  override def doAction(): Unit = {
    context.doAttack()
  }
}

