package cl.ravenhill.oop.frfr

import model.characters.{EnemyCharacter, GameCharacter, PlayerCharacter}
import model.items.{Ether, Item, PhoenixDown, Potion}
import model.items.factories.{EtherFactory, ItemFactory, PhoenixDownFactory, PotionFactory}
import states.{GameState, IdleState, SelectingTargetState}
import view.UserInterface

import scala.collection.mutable

/** A game controller for managing the characters, states, and items in a game.
  *
  * This class is the core of the game and handles the transition of states, battles,
  * character selection and attack, as well as the creation and inventory management
  * of items using item factories.
  *
  * It maintains a list of player and enemy characters, as well as a queue for managing turns.
  * It also manages the current state of the game and the selection of characters.
  *
  * The inventory is represented as a map of items keyed by their names.
  *
  * @param userInterface The user interface to use for displaying the game.
  * @constructor Creates a new GameController with an empty character lists, queue,
  *              and an initial state of IdleState.
  *
  * @author <a href="https://www.github.com/r8vnhill">R8V</a>
  * @since 1.0
  * @version 1.0
  */
class GameController(val userInterface: UserInterface) {

  /** List of PlayerCharacter instances participating in the game.
    * Initially empty.
    */
  private var playerCharacters = List.empty[PlayerCharacter]

  /** List of EnemyCharacter instances participating in the game.
    * Initially empty.
    */
  private var enemyCharacters = List.empty[EnemyCharacter]

  /** Queue to manage turns of the GameCharacter instances.
    * Initially empty.
    */
  private val turnsQueue = mutable.Queue.empty[GameCharacter]

  /** Current state of the game, initially set to an instance of IdleState. */
  var state: GameState = new IdleState(this)

  /** The currently selected GameCharacter, if any, used for game actions such as attack. */
  private var selection: Option[GameCharacter] = None

  /** The current GameCharacter whose turn it is to perform an action. */
  private var currentCharacter: Option[GameCharacter] = None

  /** Map representing the inventory of the game, with Item names as keys and corresponding Item instances as values. */
  private val inventory = mutable.Map.empty[String, Item]

  /** A factory for creating Potion instances. */
  private val potionFactory = new PotionFactory

  /** A factory for creating Ether instances. */
  private val etherFactory = new EtherFactory

  /** A factory for creating PhoenixDown instances. */
  private val phoenixDownFactory = new PhoenixDownFactory

  /** Starts a new game with the specified player and enemy characters.
    *
    * This method initializes the game by creating [[PlayerCharacter]] and [[EnemyCharacter]]
    * instances for each name provided in the respective lists.
    * The state of the game is then set to [[IdleState]].
    * The input parameters are lists of strings rather than lists of characters.
    * This approach is designed to maintain the separation of concerns between the game's model and
    * its view, as per the Model-View-Controller (MVC) architectural pattern.
    * The view (which calls this method) does not need to be aware of the [[GameCharacter]] trait or
    * its subclasses; it only needs to provide a list of names.
    * The [[GameController]] is then responsible for constructing the [[GameCharacter]] objects
    * from these names.
    *
    * @param playerCharacters A list of names for the player characters to be added to the game.
    * @param enemyCharacters  A list of names for the enemy characters to be added to the game.
    */
  def startGame(
      playerCharacters: List[String],
      enemyCharacters: List[String]
  ): Unit = {
    playerCharacters.foreach(addPlayerCharacter)
    enemyCharacters.foreach(addEnemyCharacter)
    state = new IdleState(this)
  }

  /** Initiates a battle by transitioning the game state to the [[SelectingTargetState]].
    *
    * This method is called when the player initiates a battle.
    * The game state is transitioned to the [[SelectingTargetState]], which will subsequently handle
    * the battle logic.
    */
  def battle(): Unit = state.toSelectingTargetState()

  /** Prompts the user to select an enemy character to attack.
    *
    * This method is called when the game state is in the [[SelectingTargetState]].
    * It displays a list of enemy characters by index and their respective names, then reads
    * an integer input from the user representing the index of the character they wish to attack.
    * The selected character is then stored in the [[selection]] option, and the
    * [[GameState.doAction doAction]] method of the current game state is called, triggering the
    * attack.
    */
  def promptSelection(): Unit = {
    println("Select a character to attack")
    val input = userInterface.promptSelection(enemyCharacters.map(_.name))
    selection = Some(enemyCharacters(input))
    state.doAction()
  }

  /** Executes an attack from the current character to the selected enemy character.
    *
    * This method retrieves the [[GameCharacter]] instances from the [[currentCharacter]] and
    * [[selection]] [[Option]] instances and then calls the [[GameCharacter.attack attack]] method on
    * the [[currentCharacter]], passing the [[selection]] as the target.
    *
    * This method is typically called in the context of the [[SelectingTargetState]] after the target
    * has been selected via the [[promptSelection]] method.
    *
    * @throws NoSuchElementException If [[currentCharacter]] or [[selection]] is not set.
    */
  def doAttack(): Unit = {
    currentCharacter.get.attack(selection.get)
  }

  /** Adds a [[Potion]] to the game's inventory.
   *
   * This method creates a [[Potion]] with the specified `name` and `healing` effect and adds it
   * to the [[inventory]].
   * The [[Potion]] is created using a [[PotionFactory]] instance, which allows the potion's
   * properties to be set dynamically after the factory's creation.
   *
   * The `healing` effect and `name` are first set on the `potionFactory`, then the
   * [[addToInventory]] method is called, which uses the `potionFactory` to create the `Potion` and
   * add it to the `inventory`.
   *
   * @param name    The name of the `Potion` to be added to the inventory.
   * @param healing The healing effect of the `Potion` to be added to the inventory.
   */
  def addPotion(name: String, healing: Int): Unit = {
    potionFactory.healing = Some(healing)
    addToInventory(potionFactory, name)
  }

  /** Adds an [[Ether]] to the game's inventory.
   *
   * This method creates an [[Ether]] with the specified `name` and `restore` value and adds it
   * to the [[inventory]].
   * The [[Ether]] is created using an [[EtherFactory]] instance, which allows the Ether's
   * properties to be set dynamically after the factory's creation.
   *
   * The `restore` value and `name` are first set on the `etherFactory`, then the `addToInventory`
   * method is called, which uses the `etherFactory` to create the `Ether` and add it to the `inventory`.
   *
   * @param name    The name of the `Ether` to be added to the inventory.
   * @param restore The restore value of the `Ether` to be added to the inventory.
   */
  def addEther(name: String, restore: Int): Unit = {
    etherFactory.restore = Some(restore)
    addToInventory(etherFactory, name)
  }

  /** Adds a [[PhoenixDown]] to the game's inventory.
   *
   * This method creates a [[PhoenixDown]] with the specified `name` and adds it to the
   * [[inventory]].
   * The [[PhoenixDown]] is created using a `PhoenixDownFactory` instance
   * (`phoenixDownFactory`), which allows the `PhoenixDown`'s name to be set dynamically after
   * the factory's creation.
   *
   * The `name` is first set on the `phoenixDownFactory`, then the `addToInventory`
   * method is called, which uses the `phoenixDownFactory` to create the `PhoenixDown`
   * and add it to the `inventory`.
   *
   * @param name The name of the `PhoenixDown` to be added to the inventory.
   */
  def addPhoenixDown(name: String): Unit = {
    addToInventory(phoenixDownFactory, name)
  }

  /** Adds an item to the game's inventory.
   *
   * This private method creates an [[Item]] with the specified `name` using the provided `factory`
   * and adds it to the [[inventory]].
   * The [[Item]]'s name is set on the `factory`, which is then used to create the `Item` and add it
   * to the `inventory`.
   *
   * The use of a factory allows the type of [[Item]] created to be determined by the concrete
   * `ItemFactory` instance passed in, providing flexibility in creating different types of items
   * (e.g., [[Potion]], [[Ether]], [[PhoenixDown]]).
   *
   * @tparam T The type of the item to add to the inventory.
   *           Must be a subtype of [[Item]].
   * @param factory An [[ItemFactory]] for creating instances of `T`.
   * @param name    The name of the item to be added to the inventory.
   */
  private def addToInventory[T <: Item](factory: ItemFactory[T], name: String): Unit = {
    factory.name = Some(name)
    val item = factory.createItem()
    inventory += (item -> item)
  }

  /** Adds a player character to the game.
   *
   * This method creates a new instance of [[PlayerCharacter]] with the provided `name` and adds it
   * to the list of `playerCharacters` in the game.
   *
   * @param name The name of the player character to be added to the game.
   */
  def addPlayerCharacter(name: String): Unit = {
    playerCharacters = playerCharacters :+ new PlayerCharacter(name)
  }

  /** Adds an enemy character to the game.
   *
   * This method creates a new instance of [[EnemyCharacter]] with the provided `name` and adds it
   * to the list of `enemyCharacters` in the game.
   *
   * @param name The name of the enemy character to be added to the game.
   */
  def addEnemyCharacter(name: String): Unit = {
    enemyCharacters = enemyCharacters :+ new EnemyCharacter(name)
  }
}
