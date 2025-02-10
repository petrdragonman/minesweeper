// public class Grid {
//     static void drawGrid() {
//         // Define the size of the grid
//         int rows = 3;
//         int cols = 3;

//         // Print the column headers
//         System.out.print("   ");
//         for (int j = 0; j < cols; j++) {
//             System.out.print("  "+ (j+1) +"  ");
//         }
//         System.out.println();
//         // for (char a = 'A'; a < 'A' + cols; a++) {
//         //     System.out.print("  " + a + "  ");
//         // }
//         // System.out.println();

//         // top border of the grid
//         System.out.print("  +");
//         for (int j = 0; j < cols; j++) {
//             System.out.print("----+");
//         }
//         System.out.println();
//         // the grid
//         for (int i = 1; i <= rows; i++) {
//             System.out.print(i + " |");
//             for (int j = 0; j < cols; j++) {
//                 System.out.print("    |"); // Empty cells
//             }
//             System.out.println();
//             // horizontal divider after each row
//             System.out.print("  +");
//             for (int j = 0; j < cols; j++) {
//                 System.out.print("----+");
//             }
//             System.out.println();
//         }
//     }
// }

// /**
//  * public class Grid {
//     static void drawGrid() {
//         System.out.println("");
//         System.out.println("     A   B   C   D   E   F   G   H   I   J  ");
//         for(int i = 1; i <= 10; i++) {
//             if(i < 10) {
//                 System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
//                 System.out.println(i+"  |   |   | 1 |   |   |   |   |   |   |   |");
//             } else {
//                 System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
//                 System.out.println(i+" |   |   |   |   |   |   |   |   |   |   |");
//             }
//         }
//         System.out.println("   +---+---+---+---+---+---+---+---+---+---+");
//         System.out.println("");
//     }
// }
//  */