package acmtimus.problem1327;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 11/18/16.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                Main.run();
            }
        }, "solution", 1 << 23).start();
    }

    public static void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);


        int a = in.nextInt();
        int b = in.nextInt();

        int i = (b + 2 - 1) / 2;
        int j = a / 2;

        out.print(i - j);

        out.close();
    }

}
