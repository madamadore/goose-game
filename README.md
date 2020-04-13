# Goose Game
This is my personal solution to [Goose-Game kata](https://github.com/xpeppers/goose-game-kata) from Matteo Vaccari, you can find the original slides [here](https://www.slideshare.net/pierodibello/il-dilettevole-giuoco-delloca-coding-dojo).

Goose game is a game where two or more players move pieces around a track by rolling a die. The aim of the game is to reach square number sixty-three before any of the other players and avoid obstacles. ([wikipedia](https://en.wikipedia.org/wiki/Game_of_the_Goose))

This software is licensed under free GNU General Public License.

Personally, I decided to fully decouple tiles and command from game actions, in order to simplify the chance of customize or extends the game with new features and rules.

## Requirements
To compile and play this game, you need a Java SE Edition major or equal to version 8, that you can download from [here](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html), if you don't have already.

You can check your installation by open a terminal and tiping:
```bash
java -version
```

You should receive an output similar to this one:

```bash
java version "1.8.0_05"
Java(TM) SE Runtime Environment (build 1.8.0_05-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.5-b02, mixed mode)
```

## Compile
First of all, you need to clone or download this repository:

Clone this respository:
```bash
git clone https://github.com/madamadore/goose-game.git
```

if you have [Maven](https://maven.apache.org/) installed, please read the specific section below. Otherwhise, keep reading.

### Compile with Unix, Linux or MacOSX
enter into `goose-game` directory and enter the following command:

```bash
./compile.sh
```

now you can play the game simply by typing:
```bash
java -jar goose-1.0.jar
```

### Compile with Windows
enter into `goose-game` directory and enter the following command:

```bash
./compile.bat
```

now you can play the game simply by typing:
```bash
java -jar goose-1.0.jar
```

## Commands

### Add Player

**add player <player name>**

e.g.
```bash
add player teo
```

### Move

**move <player name>**

e.g.
```bash
move teo
```

You can also spcify the dice roll:

e.g.
```bash
move teo 3,3
```

### Quit

if you want to end the game before its finished, simply type **quit**