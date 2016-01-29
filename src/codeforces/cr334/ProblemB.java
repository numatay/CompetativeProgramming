package codeforces.cr334;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ProblemB {
    public void solve() throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        PrintWriter wr = new PrintWriter(new FileWriter("path.out"));

		/* solution */
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int s[] = new int[n];
        line = br.readLine().split(" ");
        int i = 0;
        for (String l : line) {
            s[i++] = Integer.parseInt(l);
        }


        wr.close();
    }


    public static void main(String[] args) {

        ProblemB p = new ProblemB();
        try {
            p.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
