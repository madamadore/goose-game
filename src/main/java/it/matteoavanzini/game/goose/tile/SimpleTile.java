package it.matteoavanzini.game.goose.tile;

public class SimpleTile extends AbstractTile {

    public SimpleTile(int number) {
        super(null, number);
    }

    public SimpleTile(int number, String name) {
        super(null, number);
        this.name = name;
    }

}