<h1 align="center">Crazy Circus Game · IUT de Paris - Rives de Seine</h1>

The "Crazy Circus Game" GitHub project is an application that allows multiple players to play a game of Crazy Circus. The application ensures adherence to the game's rules and manages the entire progression of the game until the announcement of the best tamer.

> [!IMPORTANT]  
> The project has been developed exclusively in a professional context, with the specific aim of promoting learning. It is carried out as a project for the University of Paris.

<p align="center">
  <img src="https://github.com/Corentin-Lcs/iut-crazy-circus-game/blob/main/Crazy_Circus.png" alt="Crazy_Circus.png"/>
</p>

## Game Rules

The game aims to determine which is the best tamer among the players. It is a question of succeeding in a taming exercise involving three animals : a `lion`, a `white bear` and an `elephant`. These animals are distributed on two podiums : one is `blue`, the other is `red`. When two or three animals are on the same podium, they form a stack.

Animals only react to 5 distinct commands :

- `KI` : The animal at the top of the blue podium stack jumps to the top of the red podium stack
- `LO` : The animal at the top of the red podium stack jumps to the top of the blue podium stack
- `SO` : The two animals at the top of the stacks of the two podiums swap places
- `NI` : The animal at the bottom of the stack of the blue podium moves up and places itself at the top of the same podium's stack
- `MA` : The animal at the bottom of the stack of the red podium moves up and places itself at the top of the same podium's stack

The goal of the game is to find as quickly as possible the correct sequence of commands that, when performed by the animals, will lead them from a starting situation to a desired situation. The player who first finds a correct sequence wins the round. A player who provides an incorrect sequence can no longer propose another one for that round. If, during a round, there is only one player left who has not proposed a sequence, that player wins the round.

The initial starting situation of the game and the target situation for each round are determined by randomly drawing one of the `24 cards` representing each possible situation. The situation reached after a round becomes the starting situation for the next round. Once a card is drawn, it is not put back into play and the game ends when all the cards have been exhausted. The player who has won the most rounds wins the game.

## Description

The application allows players to compete during a complete game. The identities of the players (their first names or nicknames for example) must be received on the command line when the program is launched.

The starting situation is displayed at the `top left` and the target situation is indicated on the `right`. The different possible commands are reminded at the `bottom`. Multiple different sequences can be correct for a game situation.

When a player wants to play, he enters his identity followed by the sequence of commands he proposes. For example, if `Pierre` is a known identity, the player can enter `Pierre KIMALONI`.

If the identity is not known, the sequence is ignored and an error message is displayed. If the player is not allowed to play (i.e. he has already made a mistake) or if the sequence is incorrect, an informative message is displayed by the program. If the sequence is correct, the player earns a point, a new game situation is randomly chosen by the program from those that have not yet been played and a new round can begin.

At the end of the game, the players' scores and rankings are displayed (by decreasing score and in alphabetical order in case of a tie).

> To better understand the conditions and progress of a game, please consult the manual for the subject by clicking [here](https://github.com/Corentin-Lcs/iut-crazy-circus-game/blob/main/Sujet.pdf).

## Usage

To compile all `.java` classes, use the following command :

```
javac -d bin src/Main.java src/**/*.java
```

This command uses the `-d` option to specify the destination directory for the `.class` files, which is `bin/` in this case. Paths to `.java` files are specified using the pattern `src/Main.java` and `src/**/*.java` in order to include all the files present in the respective subdirectories.

To run the Java program, type the following command :

```
java -cp bin Main <player_name1> <player_name2>
```

This command uses the `-cp` option to specify the classpath to the `bin/` directory, which contains the compiled `.class` files. The executable expects two arguments, which are player 1 and player 2.

> For more details about the concept of compilation in Java,, here are some useful links :
>
> Link 1 : <https://www.prepbytes.com/blog/java/java-compilation-process> [EN]
>
> Link 2 : <https://www.baeldung.com/javac> [EN]

## Project's Structure

```
iut-crazy-circus-game/
├─ README.md
├─ LICENSE
├─ Sujet.pdf
├─ Sujet.tex
├─ Règles.pdf
├─ Crazy_Circus.png
└─ src/
   ├─ Main.java
   ├─ cards/
   │  ├─ Card.java
   │  ├─ CardGenerator.java
   │  ├─ DeckOfCards.java
   │  └─ PermutationGenerator.java
   ├─ color/
   │  └─ Color.java
   ├─ game/
   │  ├─ CombinationFinder.java
   │  ├─ CombinationInputState.java
   │  ├─ Game.java
   │  ├─ GameDisplayBuilder.java
   │  ├─ Pair.java
   │  └─ Player.java
   ├─ podium/
   │  ├─ Animal.java
   │  └─ Podium.java
   └─ tests/
      ├─ CardTest.java
      ├─ CombinationFinderTest.java
      ├─ GameTest.java
      ├─ PlayerTest.java
      └─ PodiumTest.java
```

Named `Sujet.pdf` (Subject.pdf), the file contains the subject of the project and is the compiled version of `Sujet.tex` (Subject.tex).

Named `Règles.pdf` (Rules.pdf), the file contains general information about the game and its rules.

## Meta

Created by [@Corentin-Lcs](https://github.com/Corentin-Lcs). Feel free to contact me !

Distributed under the GNU GPLv3 license. See [LICENSE](https://github.com/Corentin-Lcs/iut-crazy-circus-game/blob/main/LICENSE) for more information.
