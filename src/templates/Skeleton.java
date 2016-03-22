package templates;

import java.io.*;
import java.util.*;

/**
 * Created by macnur on 3/19/16.
 */
public class Skeleton {
	public static void main(String[] args) {
		// initialize resources
		InputReader in = new InputReader(System.in);
		PrintWriter out = new PrintWriter(System.out);

		// solution


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
