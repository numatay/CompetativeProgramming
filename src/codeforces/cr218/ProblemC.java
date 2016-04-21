package codeforces.cr218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        if (cb > 0) r += nb * pb;
        if (cs > 0) r += ns * ps;
        if (cc > 0) r += nc * pc;

        //System.out.println(r);

        long lt = 1, mid = 0, rt = r * 7;
        boolean ret = true;
        while (lt < rt && rt+1 != mid) {
            mid = (rt + lt)/2;

            if (canBuy(cb, cs, cc, pb, ps, pc, r, mid)) {
                lt = mid;
            } else {
                rt = mid;
            }

        }
        System.out.println(Math.min(lt, mid));
        System.out.println(rt);
        System.out.println(mid);

    }

    private static boolean canBuy(int tb, int ts, int tc, int b, int s, int c, long r, long count) {
        long price = (tb * b + ts * s + tc * c ) * count;
        //System.out.println("price: " + price);
        if (r - price > 0)
            return true;
        else
            return false;
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
