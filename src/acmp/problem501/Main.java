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
        int n = in.nextInt();

        int[] a = new int[n * 4];
        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();

        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        int sum = 0;
        for (int i = 0; i < 4*n; i+=4) {
            int curX1 = a[i];
            int curY1 = a[i + 1];
            int curX2 = a[i + 2];
            int curY2 = a[i + 3];

            int curMinX = Math.min(curX1, curX2);
            int curMaxX = Math.max(curX1, curX2);
            int curMinY = Math.min(curY1, curY2);
            int curMaxY = Math.max(curY1, curY2);

            int intervalMinX = Math.min(curMinX, minX);
            int intervalMaxX = Math.max(curMaxX, maxX);
            int intervalMinY = Math.min(curMinY, minY);
            int intervalMaxY = Math.max(curMaxY, maxY);


            if (intervalMaxX - intervalMinX <= (curMaxX - curMinX) + (maxX - minX) &&
                    intervalMaxY - intervalMinY <= (curMaxY - curMinY) + (maxY - minY)) {

                int h = ((curMaxX - curMinX) + (maxX - minX)) - (intervalMaxX - intervalMinX);
                int w = ((curMaxY - curMinY) + (maxY - minY)) - (intervalMaxY - intervalMinY);

                sum += h * w;
            }

        }

        out.print(sum);

        // release resources
        out.close();
    }
}
