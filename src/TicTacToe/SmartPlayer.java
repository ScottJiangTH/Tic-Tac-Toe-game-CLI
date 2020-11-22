package TicTacToe;

/**
 * The type Smart player.
 */
public class SmartPlayer extends BlockingPlayer {
    /**
     * Instantiates a new Smart player.
     *
     * @param name the name
     * @param mark the mark
     */
    public SmartPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    protected void makeMove() {
        if (playSmart()) return;
        if (playBlocking()) return;
        playRandom();
    }

    /**
     * Test for winning boolean.
     *
     * @param row the row
     * @param col the col
     * @return the boolean
     */
    protected boolean testForWinning(int row, int col) {
        Board tempBoard = board;
        if (tempBoard.checkWinner(super.getMark()) == 1) {
            board.addMark(row, col, super.getMark());
            return true;
        }
        return false;
    }

    /**
     * smart players default actions, loop through the board
     * to find a winning spot
     * @return
     */
    private boolean playSmart() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                if (super.board.getMark(i, j) == ' ' && testForWinning(i, j)) {
                    super.board.addMark(i, j, mark);
                    return true;
                }
            }
        }
        return false;
    }
}