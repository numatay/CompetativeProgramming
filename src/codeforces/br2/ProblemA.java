package codeforces.br2;

import java.io.*;
import java.util.*;

/**
 * Created by macnur on 3/19/16.
 */
public class ProblemA {
    public static void main(String[] args) {
        // initialize resources
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        // solution

        int n = in.nextInt();

        String name;
        int score;

        Map<String, Integer> hm = new HashMap<>();
        List<Map.Entry<String, Integer>> hist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            name = in.next();
            score = in.nextInt();

            updateRound(hm, name, score, hist);
        }

        String maybeWinner = null;
        int maxScore = Integer.MIN_VALUE;

        for (Integer curScore: hm.values()) {
            maxScore = Math.max(maxScore, curScore);
        }

        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> t: hist) {
            maybeWinner = t.getKey();
            score = t.getValue();
            if (score >= maxScore && !winners.contains(maybeWinner) && hm.get(maybeWinner) == maxScore)
                winners.add(maybeWinner);
        }

        out.print(winners.get(0));

        // release resources
        out.close();
    }

    public static void updateRound(Map<String, Integer> bag, String name, int score, List<Map.Entry<String, Integer>> hist) {
        int curScore = 0;
        if (!bag.containsKey(name)) {
            bag.put(name, score);
        } else {
            curScore = bag.get(name);
            bag.put(name, curScore + score);
        }
        hist.add(new AbstractMap.SimpleEntry<>(name, curScore + score));
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
