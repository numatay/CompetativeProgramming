package leetcode.problem283;

/**
 * Created by Nurgissa on 6/3/2016.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            swapZero(nums, i, i+1);
        }
    }

    private void swapZero(int[] a, int i, int j) {
        if (i < a.length && j < a.length) {
            if (a[i] == 0 && a[j] == 0) {
                swapZero(a, i, j+1);
            }
            if (a[i] == 0 && a[j] != 0) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
}