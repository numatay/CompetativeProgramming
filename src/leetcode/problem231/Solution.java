package leetcode.problem231;

/**
 * Created by macnur on 4/28/16.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        //return (n > 0 && (Integer.highestOneBit(n) ^ n) == 0 ) ? true : false;
        return ((n > 0) && (n & (n - 1)) == 0);
    }
}