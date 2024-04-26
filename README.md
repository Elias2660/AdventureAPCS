## Console Game

* This project must be saved in your assignments repo => classwork/xx_console_game/your_files_here (replace xx with the corresponding classwork number).
* Design a game where a player can have a different job/role.
* Choosing a different job will alter how the player can play the game and what specific things they can do.
* All kinds of players will have some common characteristics. Having a common class will help to represent this behavior.
* Job/role is called "class" in these kinds of games, but we will not use that term.

![image](https://github.com/novillo-cs/apcsa_material/assets/123229891/53bbe3cd-604e-464c-88a3-eb37a78af754)

Example:

![image](https://github.com/novillo-cs/apcsa_material/assets/123229891/e13f82b2-85d9-481e-bd8d-242bb9a30035)

### Player class (superclass):
* What things must all types of players have as their properties? Focus on big ideas about the player itself, not items or possessions. 

### Subclasses:

* Design 3 subclasses using any theme you wish.

* Does not have to be fantasy or anything common in games. What attributes/fieds or actions/methods might be required now?

* The subclasses can override the attack method as well as add new attributes. Attributes like mana would be added to magical characters, while a Barbarian might have a new attribute for their level of rage.

* There are many groups of jobs in different settings

    * Warrior / Wizard / Archer
    * Soldier / Spy / Politician
    * Princess / Pony / Monster
    * Others
 
Are we going to use the superclass to instantiate objects?

### Let's start

* Use the code provided for the superclass Adventurer.
* Implement one subclass of Adventurer and test it with a driver. You must implement all abstract methods.
* In the driver, the player should be declared as Adventurer and instantiated as the subclass (Adventurer player1 = new Warrior("Bob", 10);).
* Your player has some HP (health points) values at the beginning of the game.
* Your attack/support/special methods return Strings because you want the option of printing the text of what happened.
