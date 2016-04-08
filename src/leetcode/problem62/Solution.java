package leetcode.problem62;

/**
 * Created by Nurgissa on 4/8/2016.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cell = new int[m][n];

        for (int i = 0; i < n; i++) cell[0][i] = 1;
        for (int i = 0; i < m; i++) cell[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cell[i][j] = cell[i-1][j] + cell[i][j-1];
            }
        }
        return cell[m-1][n-1];
    }
}
