import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by marco on 6/8/2017.
 */
public class FourInALine {

    private static Scanner reader = new Scanner(System.in);
    private static String move = "none";
    private static int moveCount = 0;
    private static boolean userTurn = false;
    private static boolean userWins = false;
    private char[][] board = new char[8][8];

    public FourInALine(boolean t){
        userTurn = t;
        //b = new Board();
    }

    public void play(){
        while(!winner() && !tie()){
            if(userTurn){
                System.out.println("\nPrevious move: " + move);
                userMove();
                userTurn = false;
            }else{
                System.out.println("Computer moves.");
                userTurn = true;
            }
        }
    }

    //Allows the user to select a move on the board
    public void userMove(){

        while(true) {
            move = "";

            print();

            //Handles validity of move selection
            while (!move.matches("[a-h][1-8]")) {
                System.out.print("\nChoose your next move: ");
                move = reader.nextLine();
                move = move.toLowerCase();
            }

            char[] input = move.toCharArray();

            //Input letter converted to ASCII and scaled to correspond to matrix index
            //Numeric char value converted to integer index
            int i = ((int) input[0]) - 97;
            int j = Character.getNumericValue(input[1]) - 1;

            if(board[i][j] == '\u0000') {
                board[i][j] = 'O';
                ++moveCount;
                break;
            }else
                System.out.println("Not a valid move!");
        }
    }

    public boolean winner(){

        //Checking rows and columns for four in a row
        for(int i = 0; i < 8; ++i){
            if(Arrays.toString(board[i]).matches(".*O, O, O, O.*")){
                userWins = true;
                return true;
            }else if(Arrays.toString(board[i]).matches(".*X, X, X, X.*")){
                userWins = false;
                return true;
            }

            String column = "";

            for(int j = 0; j < 8; ++j){
                column += board[j][i];
            }

            if(column.matches(".*OOOO.*")){
                userWins = true;
                return true;
            }else if(column.matches(".*XXXX.*")){
                userWins = false;
                return true;
            }
        }

        return false;
    }

    public boolean tie(){
        return moveCount == 64;
    }

    public boolean userWon(){
        return userWins;
    }

    public void print(){

        //Printing column labels
        System.out.print("\n  1 2 3 4 5 6 7 8");

        for(int i = 0; i < 8; ++i){

            //Printing appropriate row labels based on consecutive ASCII values
            System.out.printf("%2s ", "\n" + Character.toString((char) (i + 65)));

            for(int j = 0; j < 8; ++j){
                if(board[i][j] == '\u0000'){
                    System.out.print("- ");
                }else
                    System.out.print(board[i][j] + " ");
            }
        }

        System.out.println();
    }
}