package TicTacToe;//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS


/**
 * The type Board.
 */
public class Board implements Constants {
    private final char[][] theBoard;
    private int markCount;

    /**
     * Instantiates a new Board.
     */
    public Board() {
        markCount = 0;
        theBoard = new char[3][];
        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        }
    }

    /**
     * Gets mark.
     *
     * @param row the row
     * @param col the col
     * @return the mark
     */
    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * X wins boolean.
     *
     * @return the boolean
     */
    public boolean xWins() {
		return checkWinner(LETTER_X) == 1;
    }

    /**
     * O wins boolean.
     *
     * @return the boolean
     */
    public boolean oWins() {
		return checkWinner(LETTER_O) == 1;
    }

    /**
     * Display.
     */
    public void display() {
        displayColumnHeaders();
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            System.out.print("    row " + row + ' ');
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /**
     * Add mark.
     *
     * @param row  the row
     * @param col  the col
     * @param mark the mark
     */
    public void addMark(int row, int col, char mark) {

        theBoard[row][col] = mark;
        markCount++;
    }

    /**
     * Clear.
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        markCount = 0;
    }

    /**
     * Check winner int.
     *
     * @param mark the mark
     * @return the int
     */
    int checkWinner(char mark) {
        int row, col;
        int result = 0;

        for (row = 0; result == 0 && row < 3; row++) {
            int row_result = 1;
            for (col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                result = 1;
        }


        for (col = 0; result == 0 && col < 3; col++) {
            int col_result = 1;
            for (row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                result = 1;
        }

        if (result == 0) {
            int diag1Result = 1;
            for (row = 0; diag1Result != 0 && row < 3; row++)
                if (theBoard[row][row] != mark)
                    diag1Result = 0;
            if (diag1Result != 0)
                result = 1;
        }
        if (result == 0) {
            int diag2Result = 1;
            for (row = 0; diag2Result != 0 && row < 3; row++)
                if (theBoard[row][3 - 1 - row] != mark)
                    diag2Result = 0;
            if (diag2Result != 0)
                result = 1;
        }
        return result;
    }

    /**
     * Display column headers.
     */
    void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * Add hyphens.
     */
    void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * Add spaces.
     */
    void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }

    /**
     * Gets mark count.
     *
     * @return the mark count
     */
    public int getMarkCount() {
        return markCount;
    }

    /**
     * Sets mark count.
     *
     * @param markCount the mark count
     */
    public void setMarkCount(int markCount) {
        this.markCount = markCount;
    }
}