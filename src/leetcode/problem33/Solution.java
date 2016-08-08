package leetcode.problem33;

/**
 * Created by umatayn on 8/8/2016.
 */
public class Solution {
    public int search(int[] a, int t) {
        return modBinSearch(a, 0, a.length-1, t);
    }

    private int modBinSearch(int[] a, int _l, int _r, int t) {
        int l = _l, r = _r;
        while (l < r) {
            int mid = (r+l)/2;

            if (a[mid] == t)
                return mid;

            if (a[l] <= t && t < a[mid]) {
                r = mid-1;
            } else if (a[mid] < t && t <= a[r]) {
                l = mid+1;
            } else {
                if (a[mid] > a[r]) {
                    l = mid+1;
                } else {
                    r = mid-1;
                }
            }
        }

        if (a[l] == t)
            return l;
        return -1;
    }
}
