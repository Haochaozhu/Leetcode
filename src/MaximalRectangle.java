import java.util.*;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * Number Of Corner Rectanglescontaining only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0, m = matrix.length, n = matrix[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] = matrix[i][j] == '1' ? dp[j] + 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(dp));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length, max = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                max = Math.max(max, heights[st.pop()] * (i - (st.isEmpty() ? 0 : st.peek() + 1)));
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            max = Math.max(max, heights[st.pop()] * (n - (st.isEmpty() ? 0 : st.peek() + 1)));
        }
        return max;
    }
}
