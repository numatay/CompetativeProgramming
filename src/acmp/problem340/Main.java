package acmp.problem340;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 11/18/2016.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null,
                () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int x3 = in.nextInt();

        int y1 = in.nextInt();
        int y2 = in.nextInt();
        int y3 = in.nextInt();

        int a1 = Math.max(Math.max(x1,x2),x3);
        int c1 = Math.min(Math.min(x1,x2),x3);
        int b1 = x1+x2+x3 - a1 - c1;

        int a2 = Math.max(Math.max(y1,y2),y3);
        int c2 = Math.min(Math.min(y1,y2),y3);
        int b2 = y1+y2+y3 - a2 - c2;

        if (a1 == a2 && b1 == b2 && c1 == c2) {
           out.print("Boxes are equal");
        } else if (a1 >= a2 && b1 >= b2 && c1 >= c2) {
            out.print("The first box is larger than the second one");
        } else if (a1 <= a2 && b1 <= b2 && c1 <= c2) {
            out.print("The first box is smaller than the second one");
        } else {
            out.print("Boxes are incomparable");
        }


        out.close();
    }
}
