import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int ROWS = 10;
    private static final int COLS = 10;
    private static final int MINES = 10;
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
        initializeAllBoards();
        placeMines();
        calculateDangerAproximity();
    }
    private void initializeAllBoards() {
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
    private void displayBoard(char[][] board) {
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
                System.out.print(board[i][j] + "  ");
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
        if (mineBoard[row][col] == MINE) {
            displayBoard(mineBoard);
            gameOver = true;
            System.out.println("BOOM!");
        } else {
            
            visibleBoard[row][col] = mineBoard[row][col];
            if (mineBoard[row][col] == '0') {
            }
        }
    }

    private void calculateDangerAproximity() {
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
    private void displayRules() {
        System.out.println("======= RULES =========");
        System.out.println("1. - To play please press P or p.");
        System.out.println("2. - To enter coordinates please type two numbers 0-9 with a space between them.");
        System.out.println("3. - Make sure to type in the right sequence for the coordinates Left space Top.");
        System.out.println("4. - To exit before the game starts press Q or q");
        System.out.println("=======================");
    }

    public void play() {
        boolean isInfoLoop = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scan.nextLine();
        System.out.println("Hi " + name + "! Have fun playing minesweeper?");
        System.out.println("press 'I' to read the rules");
        System.out.println("press 'P' to play");
        System.out.println("press 'Q' to quit");
        
        String option = scan.nextLine().toLowerCase();
        if(option.equals("p")) {
            isPlaying = true;
        }
        if(option.equals("i")) {
            isInfoLoop = true;
            while(isInfoLoop) {
                displayRules();
                System.out.println("press 'P' to play");
                System.out.println("press any to quit");
                option = scan.nextLine().toLowerCase();
                if(option.equals("p")) {
                    isPlaying = true;
                    isInfoLoop = false;
                }
                isInfoLoop = false;
            }
        }
        while (!gameOver && isPlaying) {
            displayBoard(visibleBoard);
            System.out.print("Enter coordinates (left top as 4 2): ");
            int row = -1;
            int col = -1;
            if(scan.hasNextInt()) {
                row = scan.nextInt();
            } else {
                scan.next(); // binning the invalid input
            }
            if(scan.hasNextInt()) {
                col = scan.nextInt();
            } else {
                scan.next(); // binning the invalid input
            }
            
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