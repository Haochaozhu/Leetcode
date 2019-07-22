import java.util.*;

/**
 * Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
 *
 * Return the maximum number of rows that have all values equal after some number of flips.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * Example 2:
 *
 * Input: [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * Example 3:
 *
 * Input: [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 *
 *
 * Note:
 *
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * All matrix[i].length's are equal
 * matrix[i][j] is 0 or 1
 */
public class FlipColumnsForMaximumNumberOfEqualRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int n : row) {
                sb1.append(n);
                sb2.append(1 - n);
            }
            map.put(sb1.toString(), map.getOrDefault(sb1.toString(), 0) + 1);
            map.put(sb2.toString(), map.getOrDefault(sb2.toString(), 0) + 1);
        }
        int ans = 0;
        for (int val : map.values()) ans = Math.max(ans, val);
        return ans;
    }

}
