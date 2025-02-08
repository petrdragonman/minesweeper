import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.play();
        //Grid.drawGrid();
    }
}




/**
 * boolean running = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name: ");
        String name = scan.nextLine();
        System.out.println("Hi " + name + "! Do you want to play minesweeper?");
        System.out.println("press 'I' to read the rules");
        System.out.println("press 'P' to play");
        System.out.println("press 'Q' to quit");
        String option = scan.nextLine();
        if(option.equals("p")) {
            running = true;
        }
        
        while(running) {
            System.out.println("press 'I' to read the rules");
            System.out.println("press 'P' to play");
            System.out.println("press 'Q' to quit");
            
            System.out.println("Enter option: ");
            option = scan.nextLine();
            System.out.println(option);
            if(option.equals("q")) {
                System.out.println("quittingi game....");
                running = false;
            }
            //if(option.equals("p")) {
                Grid.drawGrid();
            //}
            
        }
        System.out.println("GoodBye!");
        scan.close();
 */