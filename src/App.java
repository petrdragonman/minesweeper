public class App {
    public static void main(String[] args) throws Exception {
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


        System.out.println("Welcome to minesweeper!");
        System.out.println("press 'I' to read the rules");
        System.out.println("press 'P' to play");
        System.out.println("press 'Q' to quit");
    }
}

//System.out.println("+---+");
//System.out.println("|   |");
//System.out.println("+---+");

/**
 * for(int i = 1; i < 10; i++) { //columns
            //System.out.print("+");
            for(int j = 0; j < 41; j++) { //rows
                if(j%4 == 0) {
                    System.out.print("+");
                    if(j == 40) {
                        System.out.println("");
                    }
                }else {
                    System.out.print("-");
                }
                //System.out.print("+");
            //     if(j%4 == 0){
            //         System.out.print("+");
            //     } else {
            //         System.out.println("");
            //         System.out.print("-");
            //    }
                
            }
        }
 */