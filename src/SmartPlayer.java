/**
 * The subclass of BlockingPlayer class, that first looks at the board for a
 * move that could win, or would block its opponent from winning on the next
 * move. If it can't find any such move, it picks a vacant spot at random.
 *
 */
public class SmartPlayer extends BlockingPlayer {

	public SmartPlayer(String name, char letterX) {
		super(name, letterX);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Traverse through whole board to check the winning chance and opponent
	 * player's winning chance in sequence, then decide if the mark will be placed
	 * to win, or block opponent or to be placed randomly.
	 */
	protected void makeMove() {
		// check this player winning chance
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (testForBlocking(row, col, mark)) {
					board.addMark(row, col, mark);
					return;
				} else if (testForBlocking(row, col, this.opponent.mark)) {
					board.addMark(row, col, mark);
					return;
				}
			}
		}
		super.makeMove();
	}
}
