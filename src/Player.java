import java.io.IOException;

/**
 * 
 * Provides a command line user interface to prompt current Player to enter cell
 * coordinates, add corresponding mark to Board object, checks winning status,
 * and pass the turn to opponents.
 * 
 * @author Scott Tianhan Jiang
 * @version 2.0
 * @since Oct 19, 2020
 *
 */
abstract class Player {

	protected String name;
	protected Board board;
	protected Player opponent;
	protected char mark;

	protected Player(String name, char letterX) {
		this.name = name;
		this.mark = letterX;
	}

	/**
	 * Calls makeMove() method to get user input cell coordinates, check winning
	 * status and pass turn to the opponent of current Player object.
	 * 
	 * @throws IOException from makeMove() method.
	 */
	protected void play() throws IOException {
		makeMove();
		board.display();
		if (board.xWins()) {
			System.out.println("THE GAME IS OVER: whoever using X is the winner!");
		} else if (board.oWins()) {
			System.out.println("THE GAME IS OVER: whoever using O is the winner!");
		} else if (board.isFull()) {
			System.out.println("THE GAME IS OVER: it's a tie, you all lose!!!!!!");
		} else {
			opponent.play();
		}
	}

	/**
	 * An abstract method that is to be implemented by its subclasses.
	 * 
	 * @throws IOException since this method uses BufferReader
	 */
	protected abstract void makeMove() throws IOException;

	/**
	 * Sets the argument Player object as the opponent attribute of current Player
	 * object.
	 * 
	 * @param opponent represents the argument Player object.
	 */
	protected void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

	/**
	 * Sets the argument Board object to the board attribute of current object.
	 * 
	 * @param theBoard represents the argument Board object.
	 */
	protected void setBoard(Board theBoard) {
		this.board = theBoard;

	}

}
