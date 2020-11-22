package TicTacToe;

import java.util.Scanner;

/**
 * The type Human player.
 */
public class HumanPlayer extends Player {
    /**
     * Instantiates a new Human player.
     *
     * @param name the name
     * @param mark the mark
     */
    public HumanPlayer(String name, char mark) {
        super(name, mark);
    }

    /**
     * human play method
     */
    @Override
    public void play() {
        if (super.board.xWins() || super.board.oWins() || super.board.isFull()) {
            super.board.display();
            super.checkGameOutcome();
            return;
        } else {
            this.makeMove();
        }
        super.board.display();
        super.checkGameOutcome();
        System.out.println("\n");
        super.opponent.play();
    }

    /**
     * make move action for human
     */
    @Override
    public void makeMove() {
        int row;
        int col;
        while (true) {
            row = this.promptInput("row");
            col = this.promptInput("column");
            if (super.board.getMark(row, col) != ' ') {
                System.out.print("current position is occupied! \n");
            } else {
                break;
            }
        }
        super.board.addMark(row, col, super.mark);
    }

    /**
     * prompt user for input
     * @param type
     * @return
     */
    private int promptInput(String type) {
        int input;
        this.scan = new Scanner(System.in);
        System.out.printf("%s, what %s should your next %s be placed in? ", this.name, type, this.mark);
        while (true) {
            input = scan.nextInt();
            if (input!=0 && input !=1 && input!=2) {
                System.out.print("Input out of range (0-2)");
            } else {
                break;
            }
        }
        return input;
    }
}