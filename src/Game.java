import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int MINES = 5;
    private static final char UNTOUCHED = '~';
    private static final char MINE = '*';

    private char[][] board;
    private char[][] visibleBoard;
    private boolean gameOver;
    private boolean isPlaying;

    public Game() {
        board = new char[ROWS][COLS];
        visibleBoard = new char[ROWS][COLS];
        gameOver = false;
        isPlaying = false;
        initializeBoards();
        placeMines();
    }
    private void initializeBoards() {
        for (int i = 1; i < ROWS; i++) {
            for (int j = 1; j < COLS; j++) {
                board[i][j] = '0';
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
            if (board[row][col] != MINE) {
                board[row][col] = MINE;
                minesPlaced++;
                //updateAdjacentCells(row, col);
            }
        }
    }
    private void printBoard() {
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < COLS; j++) {
                System.out.print(visibleBoard[i][j] + " ");
            }
            System.out.println();
        }




        // Define the size of the grid



        
        // // Print the column headers
        // System.out.print("   ");
        // for (int j = 0; j < COLS; j++) {
        //     System.out.print("  "+ (j+1) +"  ");
        // }
        // System.out.println();
        // // for (char a = 'A'; a < 'A' + cols; a++) {
        // //     System.out.print("  " + a + "  ");
        // // }
        // // System.out.println();

        // // top border of the grid
        // System.out.print("  +");
        // for (int j = 0; j < COLS; j++) {
        //     System.out.print("----+");
        // }
        // System.out.println();
        // // the grid
        // for (int i = 1; i <= ROWS; i++) {
        //     System.out.print(i + " |");
        //     for (int j = 0; j < COLS; j++) {
        //         //System.out.print(visibleBoard[i][j] + " ");
        //         //System.out.print("    |"); // Empty cells
        //     }
        //     System.out.println();
        //     // horizontal divider after each row
        //     System.out.print("  +");
        //     for (int j = 0; j < COLS; j++) {
        //         System.out.print("----+");
        //     }
        //     System.out.println();
        // }
    }

    private boolean checkWin() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (visibleBoard[i][j] == UNTOUCHED && board[i][j] != MINE) {
                    return false;
                }
            }
        }
        return true;
    }
    private void revealCell(int row, int col) {
        System.out.println(row);
        System.out.println(col);
        if (board[row][col] == MINE) {
            gameOver = true;
            System.out.println("Game Over! You hit a mine!");
        } else {
            visibleBoard[row][col] = board[row][col];
            if (board[row][col] == '0') {
                //revealAdjacentCells(row, col);
            }
        }
    }
    public void play() {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scan.nextLine();
        System.out.println("Hi " + name + "! Have fun playing minesweeper?");
        System.out.println("press 'P' to play");
        System.out.println("press any to quit");
        String option = scan.nextLine();
        if(option.equals("p")) {
            isPlaying = true;
        }
        while (!gameOver && isPlaying) {
            printBoard();
            //Grid.drawGrid();
            System.out.print("Enter coordinates (left top as 2 3): ");
            int row = scan.nextInt();
            int col = scan.nextInt();
            if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
                revealCell(row, col);
                if (checkWin()) {
                    System.out.println("Congratulations! You won!");
                    gameOver = true;
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        scan.close();
        System.out.println("Thank you for playing, " + name + " GoodBye.");
    }
}
