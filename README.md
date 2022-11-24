# TEMA1-POO--GWENTSTONE-2022

### Objectives
- familiarise with Java base concepts
- writing generic code
- coding style
- debug skills
- constructors and inheritance

This homework consists of an implementation of the game "Heartstone", but slightly modified with new concepts from the game "Gwent"

### How to play
Gwent-Stone is a turn-based strategy game:

- there aree two players standing face to face
- each player has multiple decks of cards to choose from but at the start of every game it must decide which deck to play
- decks have two types of cards: minions and environement
- each player has one hero with 30 health in the beggining
- the game is played on a 4 X 5 table and each player has 2 rows (front row and back row)
- on the table are only minions used for attack and defense (each minion has an attack damage and a health)
- -there are special minions with special powers and also tanks (if a tank is placed on the table, the enemy cannot attact any other card unless it kills the tank)
- environement cards are used to change the properties of the cards on the table
- the game ends when a hero is killed
- for more explications and documentation about the game:
- - https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/tema
### Class hierarchy
For this game's implementation there has been created a class hierarchy:

- Package main cointains classes Main and Test (main has the entry point of the emplementation and Test is a class used to test only one case)
- Package Server contain class Server that reads the input and starts the games
- Package play contains class Play that starts every game
- Package table contains class Table that holds information about the players, their hands, their decks and the matrix table (++ multiple flags)
- Package helpme contains classes Helpme and MagicNumber
- Package game contains classes Game and StartGame
- Package format contains class Format
- Package decks contains class Decks
- Package commands contains class Commands
- Package cards contains multiple classes such as:
- - Card, Minion ,Hero and Environement
- - - Berserker
- - - Disciple
-  - - EmperessThorina
- - - Firestorm
-  - - Goliath
-  - - HeartHound
- - - KingMudface
- - - Kocioraw
- - - LordRoyce
- - - Miraj
- - - Sentinel
- - - TheCursedOne
- - - TheRipper
- - - Warden
- - - Winterfall
- Package actions contains classes Abilities, Actions, Attacks, Debug, Statistics

More details about every type of card and every ability can be found at https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/tema .

