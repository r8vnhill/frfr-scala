package cl.ravenhill.oop.frfr
package states

class GameState(val context: GameController) {
  context.state = this

  def toIdleState(): Unit = {
    transitionError("IdleState")
  }

  def toSelectingTargetState(): Unit = {
    transitionError("SelectingTargetState")
  }

  def doAction(): Unit = {
    // do nothing
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}
