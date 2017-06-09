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

        task.start();
    }
}