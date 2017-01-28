package acmp.problem131;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by macnur on 28/01/17.
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "solution", 1 << 23).start();
    }

    public void run() {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution
        int n = in.nextInt();
        int maxAge = Integer.MIN_VALUE;
        int order = -1;

        for (int i = 1; i <= n; i++) {
            int age = in.nextInt();
            int sex = in.nextInt();

            if (sex == 1 && age > maxAge) {
                maxAge = age;
                order = i;
            }
        }

        out.print(order);

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
