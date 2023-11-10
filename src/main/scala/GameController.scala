package cl.ravenhill.oop.frfr

import model.characters.{EnemyCharacter, GameCharacter, PlayerCharacter}
import model.items.Item
import model.items.factories.{EtherFactory, ItemFactory, PhoenixDownFactory, PotionFactory}
import states.{GameState, IdleState}

import cl.ravenhill.oop.frfr.model.CharacterDeathEvent
import cl.ravenhill.oop.frfr.observer.{Observer, Subject}

import scala.collection.mutable

class GameController extends Observer[CharacterDeathEvent] {

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

  def startGame(playerCharacters: Seq[(String, Int, Int)], enemyCharacter: Seq[(String, Int, Int)]): Unit = {
    for ((name, maxHealth, maxMana) <- playerCharacters) {
      addPlayerCharacter(name, maxHealth, maxMana)
    }
    for ((name, maxHealth, maxMana) <- enemyCharacter) {
      addEnemyCharacter(name, maxHealth, maxMana)
    }
    state = new IdleState(this)
  }

  override def update(observable: Subject[CharacterDeathEvent], event: CharacterDeathEvent): Unit = {
    if (event.isEnemy) {
      enemyCharacters = enemyCharacters.filterNot(_ == observable)
    } else {
      playerCharacters = playerCharacters.filterNot(_ == observable)
    }
    if (enemyCharacters.isEmpty) {
      println("You win!")
    } else if (playerCharacters.isEmpty) {
      println("You lose!")
    }
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

  def addPotion(name: String, healing: Int): Unit = {
    potionFactory.healing = Some(healing)
    addToInventory(potionFactory, name)
  }

  def addEther(name: String, restore: Int): Unit = {
    etherFactory.restore = Some(restore)
    addToInventory(etherFactory, name)
  }

  def addPhoenixDown(name: String, restore: Double): Unit = {
    phoenixDownFactory.restore = Some(restore)
    addToInventory(phoenixDownFactory, name)
  }

  def addPlayerCharacter(name: String, maxHealth: Int, maxMana: Int): Unit =
    playerCharacters = new PlayerCharacter(name, maxHealth, maxMana) :: playerCharacters

  def addEnemyCharacter(name: String, maxHealth: Int, maxMana: Int): Unit =
    enemyCharacters = new EnemyCharacter(name, maxHealth, maxMana) :: enemyCharacters
}
