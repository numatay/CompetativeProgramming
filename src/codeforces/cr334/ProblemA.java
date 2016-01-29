package codeforces.cr334;

import java.io.BufferedReader;
import java.io.FileReader;

public class ProblemA {
    public void solve() throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        //PrintWriter wr = new PrintWriter(new FileWriter("path.out"));

		/* solution */
        String[] line = br.readLine().split(" ");
        int m[] = new int[5];
        m[0] = Integer.parseInt(line[0]);
        m[1] = Integer.parseInt(line[1]);
        m[2] = Integer.parseInt(line[2]);
        m[3] = Integer.parseInt(line[3]);
        m[4] = Integer.parseInt(line[4]);

        line = br.readLine().split(" ");
        int w[] = new int[5];
        w[0] = Integer.parseInt(line[0]);
        w[1] = Integer.parseInt(line[1]);
        w[2] = Integer.parseInt(line[2]);
        w[3] = Integer.parseInt(line[3]);
        w[4] = Integer.parseInt(line[4]);

        int hs, hu;
        line = br.readLine().split(" ");
        hs = Integer.parseInt(line[0]);
        hu = Integer.parseInt(line[1]);

        double sum = 0;
        int[] x = {500, 1000, 1500, 2000, 2500};
        for (int i = 0; i < 5; i++) {
            sum += Math.max(0.3 * x[i], ((1.0 - (m[i] / 250.0)) * x[i] - 50 * w[i]));
        }
        sum += (hs * 100);
        sum -= (hu * 50);

        System.out.println(sum);


        //wr.close();
    }

    public static void main(String[] args) {

        ProblemA p = new ProblemA();
        try {
            p.solve();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}