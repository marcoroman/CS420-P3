/**
 * Created by marco on 5/23/2017.
 */

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private static String str = "";
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        MyThread task = new MyThread(10);

        //task.start();

        getInput();
    }

    static TimerTask timer = new TimerTask(){
        public void run() {
            if (str.equals("")) {
                System.out.println("No input");
                System.exit(0);
            }
        }
    };

    public static void getInput() throws Exception{
        Timer t = new Timer();
        t.schedule(timer, 5 * 1000);

        System.out.println("Input a string within 5 seconds: ");
        str = reader.nextLine();

        t.cancel();

        System.out.println("You have entered " + str);
    }
}