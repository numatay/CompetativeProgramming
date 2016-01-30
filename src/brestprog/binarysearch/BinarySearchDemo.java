package brestprog.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ABiryulin on 1/30/2016.
 */
public class BinarySearchDemo {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();


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
}
