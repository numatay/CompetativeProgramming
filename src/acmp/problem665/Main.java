package acmp.problem665;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by macnur on 02/14/2017.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    private void solve(Scanner in, PrintWriter out) {
        in.useDelimiter("\\D");

        int hh = in.nextInt();
        int mm = in.nextInt();

        int h = hh - 1;
        int m, h1, h2;

        while(true) {
            h = (h + 1) % 24;

            h1 = h / 10;
            h2 = h % 10;

            m = h2 * 10 + h1;

            if (m < 60) {
                if (hh == h && m <= mm) {
                    continue;
                } else {
                    break;
                }
            }
        }

        out.println("" + h1 + h2 + ":" + h2 + h1);
    }

    public void run() {
        // initialize resources
        Scanner in = new Scanner(System.in);
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
