/**
 * Created by marco on 5/30/2017.
 */
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        GameBoard b = new GameBoard(true);

            b.move();
            b.print();
    }
}
