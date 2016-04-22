package codeforces.cr218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by ABiryulin on 1/30/2016.
 */
public class ProblemC {
    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        String input = in.next();

        int nb = in.nextInt();
        int ns = in.nextInt();
        int nc = in.nextInt();
        int pb = in.nextInt();
        int ps = in.nextInt();
        int pc = in.nextInt();
        long r = in.nextLong();

        int cb = 0, cs = 0, cc = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'B') { cb++; }
            else if (input.charAt(i) == 'S') { cs++; }
            else { cc++; }
        }

        long lt = 0L, rt = 10000000000000L;
        while (lt < rt) {
            long mid  = (rt + lt) / 2;
            if (canBuy(cb, cs, cc, nb, ns, nc, pb, ps, pc, r, mid)) {
                lt = mid + 1;
            } else {
                rt = mid;
            }

        }

        System.out.println(lt-1);
    }

    public static boolean canBuy(int cb, int cs, int cc, int nb, int ns, int nc, int pb, int ps, int pc, long sum, long cnt) {
        long b = Math.max(0,(cb * cnt - nb) * pb) + Math.max(0,(cs * cnt - ns) * ps) + Math.max(0,(cc * cnt - nc) * pc);
        return b <= sum;
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
