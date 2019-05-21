import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
  Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        int minSum = 0;
        int A = 0, B = 0;
        for (int i = 0; i < costs.length; i += 1) {
            if (costs[i][0] < costs[i][1]) {
                minSum += costs[i][0];
                A += 1;
            } else {
                minSum += costs[i][1];
                B += 1;
            }
        }
        if (A == B) return minSum;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (A > B) {
            for (int[] cost : costs) {
                if (cost[1] >= cost[0]) pq.add(cost[1] - cost[0]);
            }
        } else {
            for (int[] cost : costs) {
                if (cost[1] <= cost[0]) pq.add(cost[0] - cost[1]);
            }
        }
        for (int i = 0; i < Math.abs(A - B) / 2; i += 1) {
            minSum += pq.poll();
        }
        return minSum;
    }
}
