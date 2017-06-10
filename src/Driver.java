/**
 * Created by marco on 5/30/2017.
 */
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        String input = "";
        boolean turn = false;

        while(!input.matches("[y|n]")) {
            System.out.print("Would you like to go first? [y/n]: ");
            input = reader.nextLine();
            input = input.toLowerCase();

            turn = input.equals("y");
        }

        FourInALine game = new FourInALine(turn);
        game.play();

        System.out.println("\nGAME OVER");
        game.print();

        if(game.tie()){
            System.out.println("CAT'S GAME!");
        }else if(game.userWon()){
            System.out.println("USER WINS!");
        }else
            System.out.println("COMPUTER WINS.");
    }
}