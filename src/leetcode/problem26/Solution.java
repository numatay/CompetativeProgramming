package leetcode.problem26;

/**
 * Created by @umatayn on 9/2/2016.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int y = 0, i = 1;
        for (; i < nums.length; i++) {
            if (nums[y] != nums[i]) {
                nums[++y] = nums[i];
            }
        }
        return y+1;
    }
}