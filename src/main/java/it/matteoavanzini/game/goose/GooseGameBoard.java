package it.matteoavanzini.game.goose;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.ActionBuilder;
import it.matteoavanzini.game.goose.action.ActionResult;
import it.matteoavanzini.game.goose.action.DefaultActionBuilder;
import it.matteoavanzini.game.goose.exception.GooseException;
import it.matteoavanzini.game.goose.input.CommandParser;
import it.matteoavanzini.game.goose.input.CommandParserInterface;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.model.TwoSixDiceRoll;
import it.matteoavanzini.game.goose.tile.BridgeTile;
import it.matteoavanzini.game.goose.tile.GooseTile;
import it.matteoavanzini.game.goose.tile.SimpleTile;
import it.matteoavanzini.game.goose.tile.Tile;
import lombok.Getter;
import lombok.Setter;

public final class GooseGameBoard implements GameBoard {
    
    @Getter
    private ActionBuilder actionBuilder;
    private CommandParserInterface parser;
    @Getter
    private DiceRoll diceRoll;
    @Setter
    private boolean prankster;
    private boolean active;
    @Getter
    private List<Tile> tiles;
    @Getter
    private List<Player> players;

    public void start() {
        active = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning()) {
            try {
                System.out.print("goose: ");
                String input = scanner.nextLine();
                Action action = parser.parse(input);

                ActionResult result = action.execute();
                System.out.println(result.getMessage());

            } catch (GooseException err) {
                System.out.println(err.getMessage());
            } 
        }
        scanner.close();
    }

    private void init() {
        for (int i =0; i<64; i++) {
            switch (i) {
                case 0:
                    tiles.add(new SimpleTile(this, i, "Start"));
                    break;
                case 6:
                    tiles.add(new BridgeTile(this, i));
                    break;
                case 5:
                case 9:
                case 14:
                case 18:
                case 23:
                case 27:
                    tiles.add(new GooseTile(this, i));
                    break;
                default:
                    tiles.add(new SimpleTile(this, i));
            }
        }
    }

    public GooseGameBoard(boolean prankster) {
        this.players = new ArrayList<>();
        this.tiles = new ArrayList<>();
        this.parser = new CommandParser(this);
        this.diceRoll = new TwoSixDiceRoll();
        this.actionBuilder = new DefaultActionBuilder();
        this.prankster = prankster;
        init();
    }

    public GooseGameBoard() {
        this(false);
    }

    public boolean isPrankster() {
        return prankster;
    }

    public boolean isRunning() {
        return active;
    }

    public DiceRoll rollDice() {
        diceRoll.roll();
        return diceRoll;
    }

    public void addParticipant(Player player) {
        this.players.add(player);
    }

    public void endGame() {
        this.active = false;
    }

    public Tile getTile(int number) {
        return tiles.get(number);
    }

    public Tile getStartingTile() {
        return tiles.get(0);
    }

    public Tile getFinalTile() {
        return tiles.get(tiles.size() - 1);
    }

    public Player getPlayer(String name) {
        for(Player p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}