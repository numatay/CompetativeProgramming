package leetcode.problem41;

/**
 * Created by Nurgissa on 02/13/2016.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) { return 1; }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != 0 && nums[i] != i) {
                if (nums[i] < 0 || nums[i] >= nums.length) {
                    break;
                }

                int j = nums[i];
                nums[i] = nums[j];
                nums[j] = j;

                if (nums[i] == j) {
                    break;
                }
            }
        }


        if (nums.length == 1) {
            if (nums[0] == 1 || nums[0] == 0) {
                return nums[0]+1;
            } else {
                return 1;
            }
        }

        int expected = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != expected) {
                break;
            }
            expected++;
        }

        if (nums[0] == expected) {
            expected++;
        }
        return expected;
    }
}