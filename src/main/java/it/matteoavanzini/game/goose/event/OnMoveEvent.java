package it.matteoavanzini.game.goose.event;

import java.util.Arrays;

import it.matteoavanzini.game.goose.GameContext;
import it.matteoavanzini.game.goose.model.DiceRoll;
import it.matteoavanzini.game.goose.model.Player;
import it.matteoavanzini.game.goose.tile.Tile;
import lombok.Getter;

public class OnMoveEvent extends AbstractActionEvent {
    @Getter
    protected Tile startingTile;
    @Getter
    protected Tile arrivalTile;
    @Getter
    protected Player player;
    protected GameContext ctx;
    @Getter
    protected int diceSum;
 
    public OnMoveEvent(GameContext context, Player player) {
        this.ctx = context;
        this.player = player;
        this.message = "%s rolls %d, %d. %s moves from %s to %s";

        int[] roll = player.getDiceRoll().getResult();
        this.diceSum = Arrays.stream(roll)
                        .boxed()
                        .mapToInt(Integer::intValue)
                        .sum();
        if (player instanceof ActionListener) {
            ActionListener target = (ActionListener) player;
            this.setTarget(target);
        }
        
        int max = ctx.getTilesCount();
        int arrivalNumber = startingTile.getNumber() + diceSum;
        if (arrivalNumber > max) {
            arrivalNumber = max;  
        }
        this.arrivalTile = ctx.getTile(arrivalNumber);
        this.message = formatMessage();
    }

    @Override
    protected Object[] getMessageParameters() {
        DiceRoll diceRoll = ctx.getDiceRoll();
        return new Object[] { 
            player.getName(),
            diceRoll.getResult()[0],
            diceRoll.getResult()[1],
            player.getName(),
            startingTile.toString(),
            arrivalTile.toString()
         };
    }
}