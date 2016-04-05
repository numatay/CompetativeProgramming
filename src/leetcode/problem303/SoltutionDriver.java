package leetcode.problem303;

/**
 * Created by Nurgissa on 4/5/2016.
 */
public class SoltutionDriver {
    public static void main(String[] args) {
        NumArray na = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        na.dumpVals();
        System.out.println(na.sumRange(0, 2));
        System.out.println(na.sumRange(2, 5));
        System.out.println(na.sumRange(0, 5));
    }
}
