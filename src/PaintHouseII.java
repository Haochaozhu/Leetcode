import edu.princeton.cs.algs4.In;

/**
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2] is the cost of painting house 1 with color 2, and so on...
 * Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Example:
 *
 * Input: [[1,5,3],[2,9,4]]
 * Output: 5
 * Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
 *              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {
    public static int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int smallest = 0, secondSmallest = 0;
        for (int i = 0; i < k; i++) {
            if (costs[0][i] < min1) {
                secondSmallest = smallest;
                min2 = min1;
                min1 = costs[0][i];
                smallest = i;
            } else if (costs[0][i] < min2) {
                min2 = costs[0][i];
                secondSmallest = i;
            }
        }

        for (int i = 1; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE;
            int temp1 = smallest, temp2 = secondSmallest;
            for (int j = 0; j < k; j++) {
                if (j == temp1) costs[i][j] += costs[i - 1][temp2];
                else costs[i][j] += costs[i - 1][temp1];
                if (costs[i][j] < curMin1) {
                    curMin2 = curMin1;
                    secondSmallest = smallest;
                    curMin1 = costs[i][j];
                    smallest = j;
                } else if (costs[i][j] < curMin2) {
                    curMin2 = costs[i][j];
                    secondSmallest = j;
                }
            }
            System.out.println(curMin1);
            System.out.println(curMin2);
        }
        for (int q : costs[1]) System.out.print(q + " ");
        return costs[n - 1][smallest];
    }
}
/**
 1 5 3
 5 10 5
 **/