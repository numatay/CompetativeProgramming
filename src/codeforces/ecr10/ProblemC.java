package codeforces.ecr10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by macnur on 3/26/16.
 */
public class ProblemC {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int lim = 0;
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            lim = Math.max(lim, a[i]);
        }

        int x, y;
        boolean[] sieve = new boolean[lim+4];

        Map<Integer, Boolean> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            x = in.nextInt();
            y = in.nextInt();
            if (x > y) { x ^= y; y ^= x; x ^= y; }
            for (int j = x; j <= y; j++) {
                sieve[j] = true;
            }
        }

        for (int z = 0; z < sieve.length; z++) {
            System.out.println(z + ") " + sieve[z]);
        }
        long cnt = n;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                x = a[i];
                y = a[j];
                if (x > y) { x ^= y; y ^= x; x ^= y; }

                System.out.print("Considering: " + x + ":" + y);
                if (sieve[x] && sieve[y] && !sieve[(x+y)/2]) { cnt++; System.out.println(x + "mid" + y); }

                if (sieve[x] && !sieve[y]) {
                    if (!sieve[x+1]) { cnt++; System.out.println(x + "lhs" + y); }
                } else if (!sieve[x] && sieve[y]) {
                    if (!sieve[y-1]) { cnt++; System.out.println(x + "rhs" + y); }
                }

                //System.out.println(x + ":" + y);
            }
        }
        System.out.println(cnt);


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
