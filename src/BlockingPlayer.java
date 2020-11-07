/**
 * The subclass of RandomPlayer class, that first looks at the board for a move
 * that would block its opponent from winning on the next move. If it can't find
 * any such move, it picks a vacant spot at random.
 *
 */
public class BlockingPlayer extends RandomPlayer {

	public BlockingPlayer(String name, char letterX) {
		super(name, letterX);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Traverse through whole board to check for opponent player's winning chance,
	 * then decide if the mark will be placed to block opponent or to be placed
	 * randomly.
	 */
	protected void makeMove() {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (testForBlocking(row, col, this.opponent.mark)) {
					board.addMark(row, col, mark);
					return;
				}
			}
		}
		super.makeMove();
	}

	/**
	 * The algorithm to check if a certain type of mark will create a winning status
	 * at a specific cell.
	 * 
	 * @param row  the row number
	 * @param col  the column number
	 * @param mark the mark type
	 * @return a boolean value to tell if this mark will win if it is placed at this
	 *         cell.
	 */
	protected boolean testForBlocking(int row, int col, char mark) {
		if (board.getMark(row, col) != ' ')
			return false;

		// check located row
		int countInRow = 0;
		for (int c = 0; c < 3; c++) {
			if (board.getMark(row, c) == mark)
				countInRow++;
		}
		if (countInRow == 2 && (board.getMark(row, col) == ' '))
			return true;

		// check located column
		int countInCol = 0;
		for (int r = 0; r < 3; r++) {
			if (board.getMark(r, col) == mark)
				countInCol++;
		}
		if (countInCol == 2 && (board.getMark(row, col) == ' '))
			return true;

		// check located diagonal 1
		if (row == col) {
			int countInDia1 = 0;
			for (int rc = 0; rc < 3; rc++) {
				if (board.getMark(rc, rc) == mark)
					countInDia1++;
			}
			if (countInDia1 == 2 && (board.getMark(row, col) == ' '))
				return true;
		}

		// check located diagonal 2
		if (row + col == 2) {
			int countInDia2 = 0;
			for (int r = 0; r < 3; r++) {
				if (board.getMark(r, (2 - r)) == mark)
					countInDia2++;
			}
			if (countInDia2 == 2 && (board.getMark(row, col) == ' '))
				return true;
		}
		return false;
	}
}
