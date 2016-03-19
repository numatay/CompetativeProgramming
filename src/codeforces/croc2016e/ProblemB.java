package codeforces.croc2016e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by macnur on 3/18/16.
 */
public class ProblemB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("in.txt"));
        String[] lines = br.readLine().split(" ");
        int n = Integer.parseInt(lines[0]);
        int k = Integer.parseInt(lines[1]);

        int times = 0;
        if (k > n/2) {
            times = k - n/2;
        }

        long sum = 0;

        if (k < n/2) {
            //calc lhs
            for (int i = 1; i <= k; i++) {
                sum += (n - i);
            }
            // middle
            sum += (n - 2*k) * k;

            //
            for (int i = k-1; i > 0; i--) {
                sum += i;
            }

        } else {

            for (int i = n - 1; i > 0; i--){
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
