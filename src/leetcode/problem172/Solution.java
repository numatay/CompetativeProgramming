package leetcode.problem172;

/**
 * Created by Nurgissa on 4/14/2016.
 */
public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trailingZeroes(25));
    }

    public int trailingZeroes(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n / 5;
            n /= 5;
        }

        return sum;
    }
}