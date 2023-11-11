package cl.ravenhill.oop.frfr

import model.characters.{EnemyCharacter, GameCharacter, PlayerCharacter}
import model.items.Item
import model.items.factories.{EtherFactory, ItemFactory, PhoenixDownFactory, PotionFactory}
import observer.{Observer, Subject}
import states.{GameState, IdleState}
import cl.ravenhill.oop.frfr.events.CharacterDeathEvent

import scala.collection.mutable

/**
 * The GameController class is a key part of the Model-View-Controller (MVC) architecture in a game application.
 * It acts as a central controller that manages game logic and state. This class demonstrates various design patterns
 * like Observer for event handling and Factory for object creation.
 *
 * @constructor Creates a new game controller, setting up the initial game state and necessary factories for item
 *              creation.
 *
 * @author [[https://www.github.com/r8vnhill Ignacio Slater M.]]
 * @since 1.0
 * @version 2.0
 */
class GameController extends Observer[CharacterDeathEvent] {

  /** Player characters in the game, demonstrating the use of a Model in MVC. */
  private var playerCharacters = List.empty[PlayerCharacter]

  /** Enemy characters in the game, also part of the Model in MVC. */
  private var enemyCharacters = List.empty[EnemyCharacter]

  /** Queue representing the turn order of characters, an aspect of game state management. */
  private val turnsQueue = mutable.Queue.empty[GameCharacter]

  /** The current state of the game, showcasing State design pattern. */
  var state: GameState = new IdleState(this)

  /** Optional current character selection, showing how the Controller manages user input and game state. */
  private var selection: Option[GameCharacter] = None

  /** The character currently taking action, illustrating interaction between Controller and Model. */
  private var currentCharacter: Option[GameCharacter] = None

  /** Inventory of items, highlighting the use of a Map collection to manage game elements. */
  private val inventory = mutable.Map.empty[String, Item]

  /** Factory for creating Potion items, demonstrating the Factory design pattern. */
  private val potionFactory = new PotionFactory

  /** Factory for creating Ether items. */
  private val etherFactory = new EtherFactory

  /** Factory for creating PhoenixDown items. */
  private val phoenixDownFactory = new PhoenixDownFactory

  /**
   * Initializes the game with specified player and enemy characters.
   * This method sets up the game's initial state in terms of player and enemy characters.
   *
   * @param playerCharacters A sequence of tuples with player character information (name, max health, max mana).
   * @param enemyCharacter   A sequence of tuples with enemy character information.
   */
  def startGame(playerCharacters: Seq[(String, Int, Int)], enemyCharacter: Seq[(String, Int, Int)]): Unit = {
    for ((name, maxHealth, maxMana) <- playerCharacters) {
      addPlayerCharacter(name, maxHealth, maxMana)
    }
    for ((name, maxHealth, maxMana) <- enemyCharacter) {
      addEnemyCharacter(name, maxHealth, maxMana)
    }
    state = new IdleState(this)
  }

  /**
   * Responds to character death events, a part of the Observer pattern. This method updates the game state
   * based on the events it observes, altering the list of characters as needed.
   *
   * @param observable The character that triggered the event.
   * @param event      The details of the character death event.
   */
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

  /**
   * Handles user input for character selection, demonstrating interaction between View (user input) and Controller.
   *
   * This implementation couples the Controller with the View, which is not ideal. A better approach would be to
   * use a dedicated class for user input handling, which would be passed to the Controller.
   */
  def promptSelection(): Unit = {
    println("Select character to attack:")
    for ((character, index) <- enemyCharacters.zipWithIndex) {
      println(s"$index) ${character.name}")
    }
    val input = scala.io.StdIn.readInt()
    selection = Some(enemyCharacters(input))
    state.doAction()
  }

  /**
   * Executes an attack action, showcasing how the Controller processes user actions and updates the Model.
   */
  def doAttack(): Unit = {
    currentCharacter.foreach { character =>
      selection.foreach { target =>
        character.attack(target)
      }
    }
  }

  /**
   * Adds an item to the game's inventory using a specific item factory, illustrating the Factory pattern.
   */
  private def addToInventory[T <: Item](factory: ItemFactory[T], name: String): Unit = {
    factory.name = Some(name)
    inventory += name -> factory.createItem()
  }

  /** Adds a potion with specified properties to the inventory. */
  def addPotion(name: String, healing: Int): Unit = {
    potionFactory.healing = Some(healing)
    addToInventory(potionFactory, name)
  }

  /** Adds an ether with specified properties to the inventory. */
  def addEther(name: String, restore: Int): Unit = {
    etherFactory.restore = Some(restore)
    addToInventory(etherFactory, name)
  }

  /** Adds a PhoenixDown with specified properties to the inventory. */
  def addPhoenixDown(name: String, restore: Double): Unit = {
    phoenixDownFactory.restore = Some(restore)
    addToInventory(phoenixDownFactory, name)
  }

  /**
   * Adds a new player character to the game. This method demonstrates updating the Model part of the MVC architecture
   * based on user input. It creates a new `PlayerCharacter`, adds the game controller as an observer to it (demonstrating
   * the Observer pattern), and then adds this character to the list of player characters.
   *
   * @param name      The name of the new player character.
   * @param maxHealth The maximum health of the new player character.
   * @param maxMana   The maximum mana of the new player character.
   */
  def addPlayerCharacter(name: String, maxHealth: Int, maxMana: Int): Unit = {
    val character = new PlayerCharacter(name, maxHealth, maxMana)
    character.addObserver(this)
    playerCharacters = character :: playerCharacters
  }

  /**
   * Adds a new enemy character to the game. Similar to `addPlayerCharacter`, this method updates the Model by creating
   * a new `EnemyCharacter`, registering the game controller as an observer, and adding this character to the list of enemy
   * characters. This ensures the game controller is notified of events related to these characters.
   *
   * @param name      The name of the new enemy character.
   * @param maxHealth The maximum health of the new enemy character.
   * @param maxMana   The maximum mana of the new enemy character.
   */
  def addEnemyCharacter(name: String, maxHealth: Int, maxMana: Int): Unit = {
    val character = new EnemyCharacter(name, maxHealth, maxMana)
    character.addObserver(this)
    enemyCharacters = character :: enemyCharacters
  }

}
