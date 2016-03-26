package codeforces.ecr10;

/**
 * Created by Nurgissa on 3/25/2016.
 */

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 3/19/16.
 */
public class ProblemA {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int h1 = in.nextInt();
        int h2 = in.nextInt();

        int a = in.nextInt();
        int b = in.nextInt();


        h1 -= (a * 4);
        int dist = h2 - h1;

        // infinity case
        if (a <= b && dist > 12) {
            System.out.println(-1);
            return;
        }



        int maxPerDay = (h2 - h1) / a;
        int days = 0;
        while (dist > 0) {
            dist -= (12 * a);
            if (dist <= 0) break;

            dist += (12 * b);
            days++;

        }

        //out.print("*");
        out.print(days);
        // release resources

        out.close();
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { return Integer.parseInt(next()); }

        public long nextLong() { return Long.parseLong(next()); }
    }
}
