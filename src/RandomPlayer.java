/**
 * Subclass of Player class, represents a player type that uses a random generator and picks a vacant spot
 * on the board, randomly. 
 *
 */
public class RandomPlayer extends Player {

	public RandomPlayer(String name, char letterX) {
		super(name, letterX);
		// TODO Auto-generated constructor stub
	}

	/**
	 * User randomly generated number as coordinate to mark board after checking vacancy.
	 */
	protected void makeMove() {
		RandomGenerator rg = new RandomGenerator();
		int row = rg.discrete(0, 2);
		int col = rg.discrete(0, 2);
		while (board.getMark(row, col) != ' ') {
			row = rg.discrete(0, 2);
			col = rg.discrete(0, 2);
		}
		board.addMark(row, col, mark);
	}

}
