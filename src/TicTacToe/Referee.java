package TicTacToe;

/**
 * The type Referee.
 */
public class Referee {

    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    /**
     * Run the game.
     */
    public void runTheGame() {
        System.out.println("TicTacToe.Referee started the game...");
        boolean gameOver = false;
        while (!gameOver) {
            board.display();
            System.out.println("\n");
            xPlayer.play();
            board.display();
            checkWins();
            gameOver = board.xWins() || board.oWins() || board.isFull();
            if (gameOver) break;
            oPlayer.play();
            gameOver = board.xWins() || board.oWins() || board.isFull();
            checkWins();
        }
    }

    private void checkWins() {
        if (board.xWins())
            System.out.println("THE GAME IS OVER: " + xPlayer.getName() + " is the winner!");
        else if (board.oWins())
            System.out.println("THE GAME IS OVER: " + oPlayer.getName() + " is the winner!");
        else
            System.out.println("THE GAME IS OVER: " + " it's a tie!");
        System.out.println("TicTacToe.Game Ended ...");
    }

    /**
     * Sets board.
     *
     * @param theBoard the the board
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    /**
     * Sets player.
     *
     * @param oPlayer the o player
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Sets player.
     *
     * @param xPlayer the x player
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}