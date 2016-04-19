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
        long m = 1, c = 0;
        for (long i = 1, j = 1; i <= n; i++, j++) {
            j = i;
            System.out.println("inside loop m:" + m + " and i:" + i + " and j:" + j + " c:" + c);
            if (j % 10 == 0) {
                while(j % 10 == 0) {
                    c++;
                    j /= 10;
                    System.out.println("cleaning up");
                }
                continue;
            }
            j %= 100;

            if (m % 10 == 0) {
                c++;
                m /= 10;
                //m %= 50;
            }
            m *= j;
            m %= 1000;

        }
        System.out.println(m);
        if (m % 10 == 0) c++;

        return (int)c;
    }
}