package it.matteoavanzini.game.goose;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
        boolean prankster = false;
        if (args.length > 0 && args[0].equals("-p")) {
            prankster = true;
        }
        GameBoard game = new GooseGameBoard(prankster);
        game.start();
    }
}
