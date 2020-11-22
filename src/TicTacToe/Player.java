package TicTacToe;

import java.util.Scanner;


/**
 * The type Player.
 */
public class Player {
    /**
     * The Name.
     */
    String name;
    /**
     * The Board.
     */
    Board board;
    /**
     * The Opponent.
     */
    Player opponent;
    /**
     * The Mark.
     */
    char mark;
    /**
     * The Scan.
     */
    Scanner scan;


    /**
     * Instantiates a new Player.
     *
     * @param name    the name
     * @param letterX the letter x
     */
    public Player(String name, char letterX) {
        this.name = name;
        this.mark = letterX;
    }

    /**
     * Instantiates a new Player.
     */
    public Player() {

    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Play.
     */
    public void play() {
        boolean valid = false;

        while (valid == false) {
            try {
                makeMove();
                valid = true;
            } catch (Exception e) {
                e.printStackTrace();
                valid = false;
            }
        }
    }

    /**
     * Make move.
     *
     * @throws Exception the exception
     */
    protected void makeMove() throws Exception {

        System.out.println(name + ", what row should your next " + mark + " be placed in?");
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        System.out.println(name + ", what column should your next " + mark + " be placed in?");
        int col = in.nextInt();
        boolean inputValid = board.getMark(row, col) == Constants.SPACE_CHAR;
        if (!inputValid) {
            throw new Exception("Exception message: Invalid move! The slot is occupied.");
        } else {
            board.addMark(row, col, mark);
        }
    }

    /**
     * Sets opponent.
     *
     * @param opponent the opponent
     */
    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Gets board.
     *
     * @return the board
     */
    public Board getBoard() {
        return board;
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
     * Check game outcome.
     */
    protected void checkGameOutcome() {
        if (this.board.checkWinner(this.mark) == 1) {
            System.out.print(this.name + " Wins!\n");
            System.out.print("Game Ended...");
            this.board.clear();
            System.exit(0);
        } else if (this.board.checkWinner(this.opponent.mark) == 1) {
            System.out.print(this.opponent.name + " Wins!\n");
            System.out.print("Game Ended...");
            this.board.clear();
            System.exit(0);
        }   else if (this.board.isFull()) {
            System.out.print("It's a tie!\n");
            System.out.print("Game Ended...");
            this.board.clear();
            System.exit(0);
        }
        else {
            return;
        }
    }

    /**
     * Gets mark.
     *
     * @return the mark
     */
    public char getMark() {
        return mark;
    }


    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", board=" + board +
                ", opponent=" + opponent +
                ", mark=" + mark +
                ", scan=" + scan +
                '}';
    }

}