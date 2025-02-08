public class Grid {
    static void drawGrid() {
        // Define the size of the grid
        int rows = 10;
        int cols = 10;

        // Print the column headers (A, B, C)
        System.out.print("   ");
        for (char a = 'A'; a < 'A' + cols; a++) {
            System.out.print("  " + a + "  ");
        }
        System.out.println();

        // Print the top border of the grid
        System.out.print("  +");
        for (int j = 0; j < cols; j++) {
            System.out.print("----+");
        }
        System.out.println();
        // Print the grid with row numbers and borders
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < cols; j++) {
                System.out.print("    |"); // Empty cells
            }
            System.out.println();

            // Print the horizontal divider after each row
            System.out.print("  +");
            for (int j = 0; j < cols; j++) {
                System.out.print("----+");
            }
            System.out.println();
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