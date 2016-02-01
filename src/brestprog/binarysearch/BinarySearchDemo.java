package brestprog.binarysearch;

import java.util.List;

/**
 * Created by ABiryulin on 1/30/2016.
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        //List<Integer> l = new ArrayList<>();

        System.out.println(binarySearchSqrt(15));


    }

    public static int binarySearch(List<Integer> lst, int value) {
        int l = 0, r = lst.size() - 1;

        while (r > l) {
            int m = (l + r) / 2;

            if (lst.get(m) < value) {
                l = m + 1;
            } else if (lst.get(m) > value) {
                r = m - 1;
            } else {
                return m;
            }
        }

        if (lst.get(l) != value) {
            return -1;
        } else {
            return l;
        }
    }
    public static double binarySearchSqrt(double x) {
        double l = 0, r = 1e9;

        while (r - l > 1e-12) {
            System.out.println(r-l);
            double mid = (r + l) / 2;
            double cur = mid * mid;

            if (cur > x) {
                r = mid;
            } else if (cur < x) {
                l = mid;
            } else  {
                return mid;
            }
        }
        return l;
    }
}
