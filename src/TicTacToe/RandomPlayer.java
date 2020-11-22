package TicTacToe;

/**
 * The type Random player.
 */
public class RandomPlayer extends Player {
    private RandomGenerator rand = new RandomGenerator();

    /**
     * Instantiates a new Random player.
     *
     * @param name the name
     * @param mark the mark
     */
    public RandomPlayer(String name, char mark) {
        super(name, mark);
    }

    /**
     * play precept for random player
     */
    @Override
    public void play() {
        if (super.board.xWins() || super.board.oWins() || super.board.isFull()) {
            super.board.display();
            super.checkGameOutcome();
        } else {
            this.makeMove();
        }
        super.board.display();
        super.checkGameOutcome();
        System.out.println("\n");
        super.opponent.play();
    }

    /**
     * calls play random
     */
    @Override
    protected void makeMove() {
        playRandom();
    }

    /**
     * Play random, create a random slot, check if it is occupied.
     * if not then play the add mark.
     */
    void playRandom() {
        int row, col;
        do {
            row = this.rand.discrete(0, 2);
            col = this.rand.discrete(0, 2);
            if (super.board.getMark(row, col) == ' ')
                break;
        } while (true);
        super.board.addMark(row, col, super.mark);
    }

}