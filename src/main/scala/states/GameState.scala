package cl.ravenhill.oop.frfr
package states

import exceptions.InvalidTransitionException

class GameState protected(val context: GameController) {
  context.state = this

  def doAction(): Unit = {
    // Do nothing
  }

  def toIdleState(): Unit = transitionError("IdleState")

  def toSelectingTargetState(): Unit = transitionError("SelectingTargetState")

  private def transitionError(targetState: String): Unit =
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
}
