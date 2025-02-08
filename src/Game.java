import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int MINES = 5;
    private static final char UNTOUCHED = '~';
    private static final char MINE = '*';

    private char[][] mineBoard;
    private char[][] visibleBoard;
    private boolean gameOver;
    private boolean isPlaying;

    public Game() {
        mineBoard = new char[ROWS][COLS];
        visibleBoard = new char[ROWS][COLS];
        gameOver = false;
        isPlaying = false;
        initializeBoards();
        placeMines();
        calculateNumbers();
        //displayBoard(mineBoard);
    }

    // private void displayBoard(char[][] b) {
    //     for (int i = 0; i < ROWS; i++) {
    //         //System.out.println(b[i].length);
    //         for (int y = 0; y < COLS; y++) {
    //             System.out.print(b[i][y]);
    //         }
    //         System.out.println();
    //     }
    // }
    private void initializeBoards() {
        for (int i = 0; i < ROWS; i++) {  
            for (int j = 0; j < COLS; j++) {
                mineBoard[i][j] = '0';
                visibleBoard[i][j] = UNTOUCHED;
            }
        }
    }
    private void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < MINES) {
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLS);
            if (mineBoard[row][col] != MINE) {
                mineBoard[row][col] = MINE;
                minesPlaced++;
            }
        }
    }
    private void printBoard() {
        for (int i = 0; i < COLS; i++) {
            if(i == 0) {
                System.out.print("  ");
            }
            System.out.print(" "+(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            System.out.print((i) + "  ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(visibleBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private boolean checkWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (visibleBoard[i][j] == UNTOUCHED && mineBoard[i][j] != MINE) {
                    return false;
                }
            }
        }
        return true;
    }
    private void revealCell(int row, int col) {
        System.out.println(row);
        System.out.println(col);
        if (mineBoard[row][col] == MINE) {
            gameOver = true;
            System.out.println("Game Over! You hit a mine!");
        } else {
            
            visibleBoard[row][col] = mineBoard[row][col];
            if (mineBoard[row][col] == '0') {
            }
        }
    }

    private void calculateNumbers() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (mineBoard[i][j] != '*') {
                    int count = countAdjacentMines(i, j);
                    mineBoard[i][j] = (char) (count + '0');
                }
            }
        }
    }
    
    private int countAdjacentMines(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < ROWS && j >= 0 && j < COLS && mineBoard[i][j] == '*') {
                    count++;
                }
            }
        }
        return count;
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scan.nextLine();
        System.out.println("Hi " + name + "! Have fun playing minesweeper?");
        System.out.println("press 'P' to play");
        System.out.println("press any to quit");
        String option = scan.nextLine().toLowerCase();
        if(option.equals("p")) {
            isPlaying = true;
        }
        while (!gameOver && isPlaying) {
            printBoard();
            //Grid.drawGrid();
            System.out.print("Enter coordinates (left top as 4 2): ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                revealCell(row, col);
                if (checkWin()) {
                    System.out.println("Congratulations! You won!");
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid input. Try again. Enter coordinates (left top as 4 2)");
            }
        }
        scan.close();
        System.out.println("Thank you for playing, " + name + " GoodBye.");
    }
}
