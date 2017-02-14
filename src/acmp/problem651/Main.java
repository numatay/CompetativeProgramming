package acmp.problem651;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 02/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    private void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();

        if (n == m) {
            out.print(0);
            return;
        }

        int max, min, maxVal, minVal;

        maxVal = max = Math.max(n, m);
        minVal = min = Math.min(n, m);

        int prime = 2;
        int total = 0;
        while (maxVal > minVal) {
            int cnt = 0;
            while (maxVal % prime == 0) {
                maxVal /= prime;
                cnt++;
            }
            if (prime == minVal) {
                cnt--;
            }
//            out.println(maxVal + " cannot be divided by " + prime);
//            out.println(prime + " - " + cnt);
            total += cnt;
            prime++;
//            while(prime * prime <= maxVal) {
//                prime++;
//                boolean isPrime = true;
//                for (int i = 2; i*i <= prime; i++) {
//                    if (prime % i == 0) {
//                        isPrime = false;
//                    }
//                }
//                if (isPrime) {
//                    break;
//                }
//            }
        }

//        out.println("prime " + prime + " minVal " + minVal + " maxVal " + maxVal);

        if (prime < minVal) {
            total++;
        }

        out.print(total);
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        solve(in, out);

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
