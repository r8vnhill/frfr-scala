package cl.ravenhill.oop.frfr

import model.characters.{EnemyCharacter, GameCharacter, PlayerCharacter}
import model.items.Item
import model.items.factories.{
  EtherFactory,
  ItemFactory,
  PhoenixDownFactory,
  PotionFactory
}
import states.{GameState, IdleState}

import scala.collection.mutable

class GameController {
  private var playerCharacters = List.empty[PlayerCharacter]
  private var enemyCharacters = List.empty[EnemyCharacter]
  private val turnsQueue = mutable.Queue.empty[GameCharacter]
  var state: GameState = new IdleState(this)
  private var selection: Option[GameCharacter] = None
  private var currentCharacter: Option[GameCharacter] = None
  private val inventory = mutable.Map.empty[String, Item]
  private val potionFactory = new PotionFactory
  private val etherFactory = new EtherFactory
  private val phoenixDownFactory = new PhoenixDownFactory

  def startGame(
      playerCharacters: List[String],
      enemyCharacters: List[String]
  ): Unit = {
    playerCharacters.foreach(addPlayerCharacter)
    enemyCharacters.foreach(addEnemyCharacter)
    state = new IdleState(this)
  }

  def battle(): Unit = state.toSelectingTargetState()

  def promptSelection(): Unit = {
    println("Select a character to attack")
    for (i <- enemyCharacters.indices) {
      println(s"$i: ${enemyCharacters(i).name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }

  def doAttack(): Unit = {
    currentCharacter.get.attack(selection.get)
  }

  def addPotion(name: String, healing: Int): Unit = {
    potionFactory.healing = Some(healing)
    addToInventory(potionFactory, name)
  }

  def addEther(name: String, restore: Int): Unit = {
    etherFactory.restore = Some(restore)
    addToInventory(etherFactory, name)
  }

  def addPhoenixDown(name: String): Unit = {
    addToInventory(phoenixDownFactory, name)
  }

  private def addToInventory[T <: Item](
      factory: ItemFactory[T],
      name: String
  ): Unit = {
    factory.name = Some(name)
    val item = factory.createItem()
    inventory += (item -> item)
  }

  def addPlayerCharacter(name: String): Unit = {
    playerCharacters = playerCharacters :+ new PlayerCharacter(name)
  }

  def addEnemyCharacter(name: String): Unit = {
    enemyCharacters = enemyCharacters :+ new EnemyCharacter(name)
  }
}
