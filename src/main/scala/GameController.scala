package cl.ravenhill.oop.frfr

import model.characters.{EnemyCharacter, GameCharacter, PlayerCharacter}
import states.{GameState, IdleState}

import cl.ravenhill.oop.frfr.model.items.Item
import cl.ravenhill.oop.frfr.model.items.factories.{EtherFactory, ItemFactory, PhoenixDownFactory, PotionFactory}

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

  def startGame(playerCharacters: Seq[(String, Int)], enemyCharacter: Seq[(String, Int)]): Unit = {
    for ((name, maxHealth) <- playerCharacters) {
      addPlayerCharacter(name, maxHealth)
    }
    for ((name, maxHealth) <- enemyCharacter) {
      addEnemyCharacter(name, maxHealth)
    }
    state = new IdleState(this)
  }

  def promptSelection(): Unit = {
    println("Select character to attack:")
    for ((character, index) <- enemyCharacters.zipWithIndex) {
      println(s"$index) ${character.name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }

  def doAttack(): Unit = {
    currentCharacter.foreach { character =>
      selection.foreach { target =>
        character.attack(target)
      }
    }
  }

  private def addToInventory[T <: Item](factory: ItemFactory[T], name: String): Unit = {
    factory.name = Some(name)
    inventory += name -> factory.createItem()
  }
  def addPlayerCharacter(name: String, maxHealth: Int): Unit = {
    playerCharacters = new PlayerCharacter(name, maxHealth) :: playerCharacters
  }

  def addEnemyCharacter(name: String, maxHealth: Int): Unit = {
    enemyCharacters = new EnemyCharacter(name, maxHealth) :: enemyCharacters
  }
}
