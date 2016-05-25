package leetcode.problem349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Nurgissa on 5/24/2016.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int l = 0, r = 0; l < nums1.length && r < nums2.length; ) {
            if (nums1[l] == nums2[r] && (ret.isEmpty() || ret.get(ret.size()-1) != nums1[l])) ret.add(nums1[l]);
            if (nums1[l] < nums2[r]) { l++; } else { r++; }
        }
        return ret.stream().mapToInt(i->i).toArray();
    }
}
