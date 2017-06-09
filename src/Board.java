import java.util.ArrayList;

/**
 * Created by marco on 6/8/2017.
 */
public class Board {

    private char[][] board = new char[8][8];
    private ArrayList<Board> children = new ArrayList<>();
    private Board parent;

    public Board(){parent = null;}

    //Creates a copy of a parent move, then stores selected move
    //Used for computer move
    public Board(int row, int col, Board b){
        parent = b;

        for(int i = 0; i < 8; ++i)
            board[i] = b.getBoard()[i].clone();

        board[row][col] = 'X';
    }

    public char[][] getBoard(){
        return board;
    }

    public Board getParent(){
        return parent;
    }

    public boolean validMove(int row, int col){
        return board[row][col] == '\u0000';
    }
}