public class Grid {
    static void drawGrid() {
        int rows = 5; // Number of rows in the grid
        int cols = 5; // Number of columns in the grid

        // Loop through each row
        for (int i = 0; i < rows; i++) {
            // Print the top border of the grid
            if (i == 0) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("+---");
                }
                System.out.println("+");
            }

            // Print the content of each cell
            for (int j = 0; j < cols; j++) {
                System.out.print("|   "); // Empty cell content
            }
            System.out.println("|");

            // Print the bottom border of the row
            for (int j = 0; j < cols; j++) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
    }
}

/**
 * public class Grid {
    static void drawGrid() {
        System.out.println("");
        System.out.println("     A   B   C   D   E   F   G   H   I   J  ");
        for(int i = 1; i <= 10; i++) {
            if(i < 10) {
                System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
                System.out.println(i+"  |   |   | 1 |   |   |   |   |   |   |   |");
            } else {
                System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
                System.out.println(i+" |   |   |   |   |   |   |   |   |   |   |");
            }
        }
        System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
        System.out.println("");
    }
}
 */