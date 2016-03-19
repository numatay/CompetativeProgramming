package codeforces.croc2016e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by macnur on 3/18/16.
 */
public class ProblemA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        char[][] b = new char[2][2];
        char[][] l = new char[2][2];

        String line = br.readLine();
        b[0][0] = line.charAt(0);
        b[0][1] = line.charAt(1);
        line = br.readLine();
        b[1][0] = line.charAt(0);
        b[1][1] = line.charAt(1);


        line = br.readLine();
        l[0][0] = line.charAt(0);
        l[0][1] = line.charAt(1);
        line = br.readLine();
        l[1][0] = line.charAt(0);
        l[1][1] = line.charAt(1);

        StringBuilder sb = new StringBuilder();
        for (String ss: getSeq(b).split("X")) {
            sb.append(ss);
        }
        String lhs = sb.toString();
        sb = new StringBuilder();
        for (String ss: getSeq(l).split("X")) {
            sb.append(ss);
        }
        String rhs = sb.toString();

        if (rhs.equals(lhs)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }

    public static String getSeq(char[][] m) {
        String res;
        if (m[0][0] == 'A') {
            res = "" + m[0][0] + m[0][1] + m[1][1] + m[1][0];
        } else if (m[0][1] == 'A') {
            res = "" + m[0][1] + m[1][1] + m[1][0] + m[0][0];
        } else if (m[1][1] == 'A') {
            res = "" + m[1][1] + m[1][0] + m[0][0] + m[0][1];
        } else {
            res = "" + m[1][0] + m[0][0] + m[0][1] + m[1][1];
        }
        return res;
    }


}
