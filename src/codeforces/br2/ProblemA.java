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


        String maybeWinner = null;
        int maxScore = Integer.MIN_VALUE;
        int curScore = 0;

        Map<String, Map.Entry<String, Integer>> hm = new HashMap<>();
        List<String> lst = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            name = in.next();
            score = in.nextInt();

            curScore = updateRound(hm, name, score, i);
        }


        List<String> winners = new ArrayList<>();
        int counter = 1;
        for (Map.Entry<String, Integer> tuple: hm.values()) {

            score = tuple.getValue();
            if (score > maxScore) {
                maxScore = score;
                counter = 1;
            } else if (score == maxScore) {
                counter++;
            }
        }

        for (Map.Entry<String, Integer> tuple: hm.values()) {
            score = tuple.getValue();
            if (score == maxScore) { winners.add(tuple.getKey()); }
        }

        int min = Integer.MAX_VALUE;
        String lines[];
        String winner = "";
        for (String line: winners) {
            lines = line.split(" ");
            int x = Integer.parseInt(lines[1]);
            //out.println(lines[0]);
            //out.println(lines[1]);
            if (x < min) {
                winner = new String(lines[0]);
                min = x;
            }
        }


        out.print(winner);


        // release resources
        out.close();
    }

    public static int updateRound(Map<String, Map.Entry<String, Integer>> bag, String name, int score, int clock) {
        int sum = score;
        Map.Entry<String, Integer> tuple;
        if (!bag.containsKey(name)) {
            tuple = new AbstractMap.SimpleEntry<>(name + " " + clock, score);
            bag.put(name, tuple);
        } else {
            tuple = bag.get(name);
            sum = tuple.getValue() + score;
            tuple.setValue(sum);
            bag.put(name, tuple);
        }
        return sum;
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
