
package cl.ravenhill.oop.frfr
package states

/**
 * Represents the selecting target state in a game's state machine, extending the `GameState` class. This state
 * is specifically used when the game requires the player to select a target, such as choosing an enemy to attack.
 * `SelectingTargetState` is a concrete implementation of a game state, providing specific behavior for the target
 * selection process in the game.
 *
 * In line with the State design pattern, `SelectingTargetState` demonstrates the implementation of state-specific
 * behaviors and transitions. It allows the transition back to the `IdleState` and overrides the `doAction` method
 * to perform an action that is relevant when in the target selection phase, such as executing an attack.
 *
 * The transition to `IdleState` is used to revert back to a passive game state, while the `doAction` method is
 * typically tied to the logic of confirming the target selection and initiating the appropriate game action,
 * for example, performing an attack.
 *
 * @constructor Creates a SelectingTargetState and sets it as the current state in the provided GameController context.
 * @param context The GameController that this state is associated with.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 2023O
 * @version 2023P
 */
class SelectingTargetState(context: GameController) extends GameState(context) {

  /**
   * Transitions the game back to the `IdleState`. This method changes the current state of the game controller
   * to a new instance of `IdleState`.
   */
  override def toIdleState(): Unit = context.state = new IdleState(context)

  /**
   * Performs the action associated with selecting a target, such as attacking. This method invokes
   * the `doAttack` method on the game controller, which handles the logic associated with the selected action.
   */
  override def doAction(): Unit = context.doAttack()
}
