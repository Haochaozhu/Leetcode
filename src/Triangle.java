import java.util.List;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.


 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        int level = triangle.size();
        int n = triangle.get(level - 1).size();
        int[] dp = new int[n];

        for (int i = 0; i < n; i += 1) {
            dp[i] = triangle.get(level - 1).get(i);
        }

        for (int i = level - 2; i >= 0; i -= 1) {
            List<Integer> curLevel = triangle.get(i);
            for (int j = 0; j < curLevel.size(); j += 1) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + curLevel.get(j);
            }
        }

        return dp[0];
    }
}
