
package cl.ravenhill.oop.frfr
package states

class SelectingTargetState(context: GameController) extends GameState(context) {

  override def toIdleState(): Unit = context.state = new IdleState(context)

  override def doAction(): Unit = context.doAttack()
}

