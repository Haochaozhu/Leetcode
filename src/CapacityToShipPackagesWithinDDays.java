/**
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * The i-th package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt
 * (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result
 * in all the packages on the conveyor belt being shipped within D days.
 * Example 1:
 *
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 = 40 cur = 9
 * need = 2
 *
 * 1st day: 1, 2, 3, 4, 5  15
 * 2nd day: 6, 7           13   38 + 17 = 55
 * 3rd day: 8              8
 * 4th day: 9              9
 * 5th day: 10             10
 * left = 10, right = 55
 * mid = 65 / 2 = 32
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 *
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 *
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 *
 * partition the array into D parts
 * minimum sum of each part
 */
public class CapacityToShipPackagesWithinDDays {

    // Left = Maximum weight item == minimum cap -> take N days (N items)
    // Right = weight sum of all items == Maximum cap -> take 1 day
    // Use binary search to find :  left < X < right
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left <= right) {
            int mid = left + right >> 1;
            if (howManyDays(weights, mid) > D) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }

    private int howManyDays(int[] weights, int cap) {
        int count = 1;
        int cur = 0;
        for (int w : weights) {
            if (cur + w > cap) {
                count += 1;
                cur = w;
            } else {
                cur += w;
            }
        }
        return count;
    }


}
