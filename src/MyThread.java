import java.util.Scanner;

/**
 * Created by marco on 5/30/2017.
 */
public class MyThread extends Thread {
    private int limit;
    private Scanner reader = new Scanner(System.in);

    public MyThread(int n){
        limit = n;
    }

    public void run(){
        long start = System.currentTimeMillis();
        long end = start + (limit * 1000);
        int i = 0;

        try {
            while(System.currentTimeMillis() < end) {
                System.out.println(++i);
                sleep(1000);
            }
        }catch(InterruptedException e){
            System.err.println(e);
        }
    }
}
