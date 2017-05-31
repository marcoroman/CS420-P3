/**
 * Created by marco on 5/30/2017.
 */
import java.util.Scanner;

public class GameBoard {
    private int[][] board = new int[8][8];
    private boolean turn = false;
    private String move;
    private char[] input = new char[2];
    private Scanner reader = new Scanner(System.in);

    public GameBoard(boolean b){
        if(b) turn = true;
    }

    public void move(){

        move = "";

        while(!move.matches("[a-h][1-8]")) {
            System.out.print("\nEnter a move: ");
            move = reader.nextLine();
            move = move.toLowerCase();
        }

        input = move.toCharArray();

        if(turn) {
            board[Character.getNumericValue(input[1]) - 1][((int) input[0]) - 97] = 1;
            turn = false;
        }else {
            board[Character.getNumericValue(input[1]) - 1][((int) input[0]) - 97] = -1;
            turn = true;
        }

        print();
    }

    public void print(){

        System.out.print("\n  1 2 3 4 5 6 7 8");

        for(int i = 0; i < 8; ++i){

            System.out.printf("%2s ", "\n" + Character.toString((char) (i + 65)));

            for(int j = 0; j < 8; ++j){

                if(board[i][j] == 1) {
                    System.out.print("X ");
                }else if(board[i][j] == -1){
                    System.out.print("O ");
                }else
                    System.out.print("- ");
            }
        }

        System.out.println();
    }
}