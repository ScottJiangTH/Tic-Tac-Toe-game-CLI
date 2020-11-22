package TicTacToe;

/**
 * The type Blocking player.
 */
public class BlockingPlayer extends RandomPlayer {
    /**
     * Instantiates a new Blocking player.
     *
     * @param name the name
     * @param mark the mark
     */
    public BlockingPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    protected void makeMove() {
        if (playBlocking()) return;
        playRandom();
    }

    /**
     * Test for blocking, if blocking return true boolean.
     *
     * @param row the row
     * @param col the col
     * @return the boolean
     */
    protected boolean testForBlocking(int row, int col) {
        Board testBoard = board;
        if (testBoard.checkWinner(opponent.getMark()) == 1) {
            board.addMark(row, col, opponent.getMark());
            return true;
        }
        return false;
    }

    /**
     * Play blocking, return boolean if block successful.
     *
     * @return the boolean
     */
    protected boolean playBlocking() {
        for (int i = 0; i <= 2 ; i++) {
            for (int j = 0; j <= 2; j++) {
                if (super.board.getMark(i, j) == ' ' && testForBlocking(i, j)) {
                    super.board.addMark(i, j, super.mark);
                    return true;
                }
            }
        }
        return false;
    }
}