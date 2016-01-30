package codeforces.cr218;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ABiryulin on 1/30/2016.
 */
public class ProblemC {
    public static void main(String[] args) throws Exception {
        solve();
    }

    public static void solve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String line = br.readLine();
        int nb, ns, nc;
        int pb, ps, pc;
        long r = 0;

        String[] vals = br.readLine().split(" ");
        nb = Integer.parseInt(vals[0]);
        ns = Integer.parseInt(vals[1]);
        nc = Integer.parseInt(vals[2]);

        vals = br.readLine().split(" ");
        pb = Integer.parseInt(vals[0]);
        ps = Integer.parseInt(vals[1]);
        pc = Integer.parseInt(vals[2]);

        r = Long.parseLong(br.readLine());

        int cost = 0;
        int c1=0, c2=0, c3=0;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'B') {
                cost += pb;
                c1 = 1;
            } else if (line.charAt(i) == 'S') {
                cost += ps;
                c2 = 1;
            } else {
                cost += pc;
                c3 = 1;
            }
        }
        long sum = nb*pb*c1 + ns*ps*c2 + nc*pc*c3 + r;
        //System.out.println(cost);
        //System.out.println(sum);



        System.out.println(sum / cost);


    }
}
