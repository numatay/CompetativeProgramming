package leetcode.problem189;

/**
 * Created by umatayn on 8/8/2016.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int _k = k % nums.length;
        _k = nums.length - _k;

        // reverse left partition
        reverse(nums, 0, _k-1);
        // reverse right partition
        reverse(nums, _k, nums.length-1);
        // reverse whole partition
        reverse(nums, 0, nums.length-1);
    }

    private static void reverse(int a[], int x, int y) {
        for (int l = x, r = y; l < r;) {
            swap(a, l, r);
            l++;
            r--;
        }
    }

    private static void swap(int a[], int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
}
