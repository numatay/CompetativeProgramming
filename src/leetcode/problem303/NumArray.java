package leetcode.problem303;

/**
 * Created by Nurgissa on 4/5/2016.
 */
public class NumArray {

    private int[] a;
    private int[] cmptd;
    public NumArray(int[] nums) {
        int sum = 0;
        this.a = new int[nums.length];
        this.cmptd = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            this.a[i] = nums[i];
            sum += nums[i];
            this.cmptd[i] += sum;
        }
    }

    public int sumRange(int i, int j) {
        return (this.cmptd[j] < 0 || this.cmptd[i] < 0 ? this.cmptd[j] + this.cmptd[i] : this.cmptd[j] + this.cmptd[i]);
    }

    public void dumpVals() {
        for (int i = 0; i < this.a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        for (int i = 0; i < this.cmptd.length; i++)
            System.out.print(cmptd[i] + " ");
        System.out.println();
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);