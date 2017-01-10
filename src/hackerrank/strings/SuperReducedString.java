package hackerrank.strings;

import java.util.*;


/**
 * Created by @umatayn on 9/21/2016.
 */
public class SuperReducedString {
    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        char[] w = in.next().toCharArray();
        char[] out = new char[w.length];
        int j = 0;
        for (int i = 0; i < w.length; i++) {
            out[j++] = w[i];
            if (j >= 2 && out[j-2] == out[j-1]) {
                j -= 2;
            }
        }
        System.out.print(j == 0 ? "Empty String" : String.copyValueOf(out, 0, j));
    }
}
