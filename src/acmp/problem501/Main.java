package acmp.problem501;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by @umatayn on 10/14/2016.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out, true);

        // solution
        long lhsX = 0, rhsX = 0, lhsY = 0, rhsY = 0;
        long plhsX = 0, prhsX = 0, plhsY = 0, prhsY = 0;

        int n = in.nextInt();

        long sum = 0;
        int counterX = 0, counterY = 0;
        int minusX = 0, minusY = 0;
        for (int i = 0; i <= n; i++) {
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();

            counterX = 0;
            minusX = 0;
            for (int j = x1; j < x2; j++) {

//                System.out.println("j=" + j);
                int offset = j % 50;
                long padding = (1L << offset);

                System.out.println("offset=" + offset);
                long checker = padding & (j < 50 ? lhsX : rhsX);
                System.out.println("checker=" + checker);
                if (checker != 0) {
                    counterX++;
                } else {

                    if (j < 50) {
                        lhsX |= padding;
                        System.out.println("lhs = " + lhsX);
                    } else {
                        rhsX |= padding;
//                        System.out.println("rhs = " + lhsX);
                    }
                }
                if (plhsX != 0 && plhsX == lhsX) {
                    minusX++;
                }
                plhsX = lhsX;

            }
            System.out.println("counterX = " + counterX);
            System.out.println("minusX = " + minusX);


            counterY = 0;
            minusY = 0;
            for (int j = y1; j < y2; j++) {

//                System.out.println("j=" + j);
                int offset = j % 50;
                long padding = (1L << offset);

//                System.out.println("offset=" + offset);
                long checker = padding & (j < 50 ? lhsY : rhsY);
//                System.out.println("checker=" + checker);
                if (checker != 0) {
                    counterY++;
                } else {

                    if (j < 50) {
                        lhsY |= padding;
                        System.out.println("lhs = " + lhsY);
                    } else {
                        rhsY |= padding;
//                        System.out.println("rhs = " + rhsY);
                    }
                }

                if (plhsY != 0 && plhsY == lhsY) {
                    minusY++;
                }
                plhsY = lhsY;
            }
            System.out.println("counterY = " + counterY);
            System.out.println("minusY = " + minusY);
            sum += (counterX * counterY);
            System.out.println("Cur SUM: " + sum);
        }

        out.print("SUM: " + sum);
        // release resources
        out.close();
    }
}
