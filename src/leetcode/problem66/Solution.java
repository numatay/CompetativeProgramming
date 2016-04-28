package leetcode.problem66;

/**
 * Created by macnur on 4/28/16.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int delta = 1;
        for (int i = digits.length-1; delta != 0 && i >= 0; i--) {
            digits[i] += delta;
            delta = digits[i] / 10;
            digits[i] %= 10;
        }
        if (delta == 1) {
            int[] res = new int[digits.length+1];
            res[0] = delta;
            System.arraycopy(res, 1, digits, 0, digits.length);
            return res;
        }
        return digits;
    }
}