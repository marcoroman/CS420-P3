/**
 * Created by marco on 5/30/2017.
 */
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        GameBoard b = new GameBoard(true);
        int i = 0;

        while(i < 10) {
            b.move();
            ++i;
        }
    }
}
