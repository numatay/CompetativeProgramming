package leetcode.problem165;

/**
 * Created by Nurgissa on 4/21/2016.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int val1 = 0, val2 = 0;
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            val1 = (i < v1.length ? Integer.parseInt(v1[i]) : 0);
            val2 = (i < v2.length ? Integer.parseInt(v2[i]) : 0);

            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
        }
        return 0;
    }
}