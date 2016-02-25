package codeforces.cr343;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by macnur on 2/25/16.
 */
public class ProblemA {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        //Scanner in = new Scanner(new FileReader("in.txt"));
        int n = in.nextInt();
        int[] h = new int[n];
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            String s = in.next();
            for (int j = 0; j < n; j++) {
                h[i] += (s.charAt(j) == '.' ? 0 : 1);
                v[j] += (s.charAt(j) == '.' ? 0 : 1);
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += cnk(h[i]);
        }

        for (int i = 0; i < n; i++) {
            sum += cnk(v[i]);
        }

        System.out.println(sum);
    }






    public static long cnk(int n) {
        int base = n - 2;
        long sum = 1;
        for (int i = n; i > base; i--) {
            sum *= i;
        }
        return sum / 2;
    }

}
