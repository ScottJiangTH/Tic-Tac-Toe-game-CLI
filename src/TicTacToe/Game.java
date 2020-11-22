package TicTacToe;

//Game.java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


/**
 * The type Game.
 */
public class Game implements Constants {

    private final Board theBoard;
    private Referee theRef;

    /**
     * Instantiates a new Game.
     */
    public Game() {
        theBoard = new Board();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        Referee theRef;
        Player xPlayer, oPlayer;
        BufferedReader stdin;
        Game theGame = new Game();
        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter the name of the 'X' player: ");
        String name = stdin.readLine();
        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

//		xPlayer = new Player(name, LETTER_X);
//		xPlayer.setBoard(theGame.theBoard);

        xPlayer = create_player(name, LETTER_X, theGame.theBoard, stdin);

        System.out.print("\nPlease enter the name of the 'O' player: ");
        name = stdin.readLine();
        while (name == null) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

//		oPlayer = new Player(name, LETTER_O);
//		oPlayer.setBoard(theGame.theBoard);

        oPlayer = create_player(name, LETTER_O, theGame.theBoard, stdin);

        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        theRef = new Referee();
        theRef.setBoard(theGame.theBoard);
        theRef.setoPlayer(oPlayer);
        theRef.setxPlayer(xPlayer);

        theGame.appointReferee(theRef);
    }

    /**
     * Create player player.
     *
     * @param name  the name
     * @param mark  the mark
     * @param board the board
     * @param stdin the stdin
     * @return the player
     * @throws IOException the io exception
     */
    static public Player create_player(String name, char mark, Board board,
                                       BufferedReader stdin) throws IOException {
        // Get the player type.
        final int NUMBER_OF_TYPES = 4;
        System.out.print("\nWhat type of player is " + name + "?\n");
        System.out.print("  1: Human\n" + "  2: Random Player\n"
                + "  3: Blocking Player\n" + "  4: Smart Player\n");
        System.out.print("Please enter a number in the range 1-" + NUMBER_OF_TYPES + ": ");
        int player_type = 0;

        String input;
        stdin = new BufferedReader(new InputStreamReader(System.in));
        input = stdin.readLine();
        player_type = Integer.parseInt(input);
        while (player_type < 1 || player_type > NUMBER_OF_TYPES) {
            System.out.print("Please try again.\n");
            System.out.print("Enter a number in the range 1-" + NUMBER_OF_TYPES + ": ");
            input = stdin.readLine();
            player_type = Integer.parseInt(input);
        }

        // Create a specific type of Player
        Player result = null;
        switch (player_type) {
            case 1:
                result = new HumanPlayer(name, mark);
                break;
            case 2:
                result = new RandomPlayer(name, mark);
                break;
            case 3:
                result = new BlockingPlayer(name, mark);
                break;
            case 4:
                result = new SmartPlayer(name, mark);
                break;
            default:
                System.out.print("\nDefault case in switch should not be reached.\n"
                        + "  Program terminated.\n");
                System.exit(0);
        }
        result.setBoard(board);
        return result;
    }

    /**
     * Appoint referee.
     *
     * @param r the r
     * @throws IOException the io exception
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
        theRef.runTheGame();
    }
}