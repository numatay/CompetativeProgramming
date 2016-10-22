package acmp.problem1110;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() { new Main().run(); }
        }, "solution", 1<<23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int num = in.nextInt();

        out.print(num % 10);

        // release resources
        out.close();
    }
}