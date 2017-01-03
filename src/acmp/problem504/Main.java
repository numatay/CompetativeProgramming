package acmp.problem504;

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

        /*
            0 -> GCV
            1 -> (GVC -> VGC)
            2 -> (VCG -> CVG)
            3 -> (CGV -> GCV)
         */
        int k = in.nextInt();
        int remainder = k % 3;

        if (remainder == 0) {
            out.print("GCV");
        } else if (remainder == 1) {
            out.print("VGC");
        } else {
            out.print("CVG");
        }
        // release resources
        out.close();
    }
}