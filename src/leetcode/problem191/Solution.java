package leetcode.problem191;

/**
 * Created by Nurgissa on 4/11/2016.
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    /*
    public int hammingWeight(int n) {
        int c = 0;
        for (int i = 0; i < 32; i++, n >>= 1) {
            if ((n & 1) == 1) c++;
        }

        return c;
    }
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingWeight(100));
    }
}
