package acmp.problem253;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by umatayn on 10/22/16.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int startHr = in.nextInt();
        int startMin = in.nextInt();

        int endHr = in.nextInt();
        int endMin = in.nextInt();

        if (startHr > endHr) {
            endHr += 24;
        }

        int i = startHr;
        int j = startMin;
        int ticks = 0;

        System.out.println(i + " "  + j + " " + endHr + " " + endMin);

        while (i < endHr || j < endMin) {
            if (j == 60) {
                i++;
                ticks += i;
                j = 0;
            } else if (j == 30) {
                ticks++;
            }
            j++;
        }
        System.out.println(ticks);

        // release resources
        out.close();
    }
}