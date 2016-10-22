package acmp.problem1112;

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

        long num = in.nextLong();
        long last = num % 10;
        long mid = (num / 10) % 10;
        long first = (num / 100) % 10;

        out.print(first + mid + last);

        // release resources
        out.close();
    }
}