package codeforces.cr341;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by ABiryulin on 2/4/2016.
 */
public class ProblemB {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        //PrintWriter wr = new PrintWriter(new FileWriter("path.out"));

		/* solution */
        int m = 1000;
        int side = 2*m+1;
        int[] horz1 = new int[side];
        int[] horz2 = new int[side];
        int n = Integer.parseInt(br.readLine());
        String[] line;

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            horz1[x+y]++;
            horz2[(x-y)+m]++;
        }

        long sum1 = 0;
        for (int l : horz1) {
            if (l > 0) {
                sum1 += cn2(l);
            }
        }
        long sum2 = 0;
        for (int l : horz2) {
            if (l > 0) {
                sum2 += cn2(l);
            }
        }



        System.out.println(sum1+sum2);

    }

    public static long cn2(int n) {
        long s = 1;

        s = (n * (n-1)) / 2;

        return s;
    }
}
