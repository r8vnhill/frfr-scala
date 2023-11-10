
package cl.ravenhill.oop.frfr
package states

class IdleState(context: GameController) extends GameState(context) {
  override def toSelectingTargetState: Unit = {
    context.state = new SelectingTargetState(context)
    context.promptSelection()
  }
}
