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

            if(input.equals("y")){
                turn = true;
            }else
                turn = false;
        }

        GameBoard b = new GameBoard();

        //GAME LOOP
        while(!b.winner()) {
            if(turn){
                System.out.println("\nMy current move is: " + b.getLastMove());
                b.userMove();
                turn = false;
            }else {
                System.out.println("Computer moves");
                turn = true;
            }
        }

        System.out.println("GAME OVER");

        if(b.userWon()){
            System.out.println("USER WINS!");
        }else
            System.out.println("COMPUTER WINS...");
    }
}