import java.util.Random;

public class Game {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 10;
    private static final char UNTOUCHED = '~';
    private static final char MINE = '*';

    private char[][] board;
    private char[][] playerBoard;
    private boolean gameOver;

    public Game() {
        board = new char[ROWS][COLS];
        playerBoard = new char[ROWS][COLS];
        gameOver = false;
        initializeBoards();
        placeMines();
    }
    private void initializeBoards() {
        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                board[i][j] = '0';
                playerBoard[i][j] = UNTOUCHED;
            }
        }
    }
    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < MINES) {
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLS);
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                minesPlaced++;
                //updateAdjacentCells(row, col);
            }
        }
    }
}
