package it.matteoavanzini.game.goose.event;

public interface OnPrankActionListener extends OnMoveActionListener {
   void onPrank(OnPrankEvent event);
}