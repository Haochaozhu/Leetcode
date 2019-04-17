/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 *
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 *
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 *
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class MaximizeDistanceToClosestPerson {
    /**
     * Two passes.
     */
    public int maxDistToClosest(int[] seats) {
        int[] distance = new int[seats.length];
        int maxDist = 0;
        int prev = Integer.MIN_VALUE / 2;
        for (int i = 0; i < seats.length; i += 1) {
            if (seats[i] == 1) prev = i;
            else distance[i] = i - prev;
        }
        prev = Integer.MAX_VALUE / 2;
        for (int i = seats.length - 1; i >= 0; i -= 1) {
            if (seats[i] == 1) prev = i;
            else {
                distance[i] = Math.min(distance[i], prev - i);
                maxDist = Math.max(maxDist, distance[i]);
            }
        }
        return maxDist;
    }

    /**
     * One pass
     */
    public int maxDistToClosest1(int[] seats) {
        int n = seats.length;
        int i = 0;
        int max = 0;
        while (i < n) {
            while (i < n && seats[i] == 1) {
                i += 1;
            }
            int j = i;
            while (i < n && seats[i] == 0) {
                i += 1;
            }
            if (j == 0 || i == n) {
                max = Math.max(max, i - j);
            } else {
                max = Math.max(max, (i - j + 1) / 2);
            }
        }
        return max;
    }
}
