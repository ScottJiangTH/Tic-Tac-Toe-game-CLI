import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The subclass of Player class, that will provide user interface to human players.
 *
 */
public class HumanPlayer extends Player {

	public HumanPlayer(String name, char letterX) {
		super(name, letterX);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Prompt for and receive user interface, check legitimacy, and add mark to
	 * Board object.
	 * 
	 * @throws IOException since this method uses BufferReader
	 */
	@Override
	protected void makeMove() throws IOException {
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));

		int row = -1;
		int col = -1;
		System.out.print(name + ", what row should your next " + mark + " be placed in?\n");
		String rowString = stdin.readLine();
		row = Integer.parseInt(rowString);
		System.out.print(name + ", what column should your next " + mark + " be placed in?\n");
		String colString = stdin.readLine();
		col = Integer.parseInt(colString);

		if (row < 0 || col < 0 || row > 2 || col > 2) {
			System.out.println("Be serious, enter integer 0 - 2, let's try again\n");
			makeMove();
		} else if (board.getMark(row, col) != ' ') {
			System.out.println("Cheating not allowed! Let's enter again\n");
			makeMove();
		} else {
			board.addMark(row, col, mark);
		}
	}

}
