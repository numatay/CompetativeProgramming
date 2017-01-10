package hackerrank.wc28;

import java.util.*;


/**
 * Created by umatay on 1/10/17.
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long x = in.nextLong();
            // your code goes here
            int c = 0;
            int bits = log2nlz(2 * x - 1);
            for (int i = 0; i < bits; i++) {
                if (((1L << i) & x) == 0) {
                    //System.out.println(i);
                    c += (1 << i);
                }
            }

            System.out.println(c);
        }
    }

    public static int log2nlz( long bits ) {
        if(bits == 0)
            return 0; // or throw exception
        return 63 - Long.numberOfLeadingZeros( bits );
    }
}
