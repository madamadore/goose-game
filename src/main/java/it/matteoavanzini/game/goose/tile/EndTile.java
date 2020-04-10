package it.matteoavanzini.game.goose.tile;

import it.matteoavanzini.game.goose.GameBoard;
import it.matteoavanzini.game.goose.action.Action;
import it.matteoavanzini.game.goose.action.BounceAction;
import it.matteoavanzini.game.goose.action.WinAction;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EndTile extends AbstractTile {

    public Action getAction() {
        Player player = EndTile.this.getLastOccupant();
        DiceRoll diceRoll = game.getDiceRoll();
        
        Tile previousPlayerTile = player.getPreviousPosition();
        int totalSum = previousPlayerTile.getNumber() + diceRoll.getSum();
        
        Action resultAction = new WinAction(player);

        if (totalSum > getNumber()) {
            resultAction = new BounceAction(player, diceRoll.getResult());
        }
        
        return resultAction;
    }
    
    public EndTile(GameBoard game, int number) {
        super(game, number);
    }

    public EndTile(GameBoard game, int number, String name) {
        super(game, number);
        this.name = name;
    }
}