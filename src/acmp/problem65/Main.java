package acmp.problem65;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 01/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // 1st quarter
        int fa = in.nextInt();
        int fb = in.nextInt();

        // 2nd quarter
        fa += in.nextInt();
        fb += in.nextInt();

        // 3rd quarter
        fa += in.nextInt();
        fb += in.nextInt();

        //4th quarter
        fa += in.nextInt();
        fb += in.nextInt();

        if (fa == fb) {
            out.print("DRAW");
        } else {
            if (fa > fb) {
                out.print(1);
            } else {
                out.print(2);
            }
        }

        // release resources
        out.close();
    }
}