/**
 * Created by marco on 5/30/2017.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
    /*board array stores the game state as a series of integer values
    *input char array is used to extract matrix indexes from user input
    *move String is used to validate user input
    *userWins indicates whether user won or lost at the conclusion of the game
    *moveCount counts the total valid moves made; used to check for ties*/

    private int[][] board = new int[8][8];
    private char[] input = new char[2];
    private String move = "None";
    private static boolean userWins;
    private static int moveCount = 0;
    private Scanner reader = new Scanner(System.in);

    public GameBoard(){}

    //Allows the user to select a move on the board
    public void userMove(int m){

        while(true) {
            move = "";

            print();

            //Handles validity of move selection
            while (!move.matches("[a-h][1-8]")) {
                System.out.print("\nChoose your next move: ");
                move = reader.nextLine();
                move = move.toLowerCase();
            }

            input = move.toCharArray();

            //Input letter converted to ASCII and scaled to correspond to matrix index
            //Numeric char value converted to integer index
            int i = ((int) input[0]) - 97;
            int j = Character.getNumericValue(input[1]) - 1;

            if(board[i][j] == 0) {
                board[i][j] = m;
                ++moveCount;
                break;
            }else
                System.out.println("Not a valid move!");
        }
    }

    public void print(){

        //Printing column labels
        System.out.print("\n  1 2 3 4 5 6 7 8");

        for(int i = 0; i < 8; ++i){

            //Printing appropriate row labels based on consecutive ASCII values
            System.out.printf("%2s ", "\n" + Character.toString((char) (i + 65)));

            for(int j = 0; j < 8; ++j){

                //1 signifies user move, -1 computer move, 0 is hyphen by default
                if(board[i][j] == 1) {
                    System.out.print("O ");
                }else if(board[i][j] == -1){
                    System.out.print("X ");
                }else
                    System.out.print("- ");
            }
        }

        System.out.println();
    }

    public boolean winner(){

        //Checking rows and columns for four in a row
        for(int i = 0; i < 8; ++i){
            if(Arrays.toString(board[i]).matches(".*1, 1, 1, 1.*")){
                userWins = true;
                return true;
            }else if(Arrays.toString(board[i]).matches(".*-1, -1, -1, -1.*")){
                userWins = false;
                return true;
            }

            String column = "";

            for(int j = 0; j < 8; ++j){
                column += board[j][i];
            }

            if(column.matches(".*1111.*")){
                userWins = true;
                return true;
            }else if(column.matches(".*-1-1-1-1.*")){
                userWins = false;
                return true;
            }
        }

        return false;
    }

    public boolean userWon(){
        return userWins;
    }

    public String getLastMove(){
        return move;
    }

    public boolean tie(){
        return moveCount == 64;
    }
}