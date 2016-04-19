package leetcode.problem88;

/**
 * Created by Nurgissa on 4/19/2016.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = n+m-1, i = m-1, j = n-1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[r--] = nums1[i--];
            } else {
                nums1[r--] = nums2[j--];
            }
        }
        for (; j >= 0;)
            nums1[r--] = nums2[j--];
    }
}

/*
    // Solution by Nurlan
    public class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            while (m>0 && n>0 || n>0) {
                nums1[m + n - 1] = m > 0 && nums1[m-1] > nums2[n-1] ? nums1[m---1] : nums2[n---1];
            }
        }
    }
 */