/**
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,3,6]
 * Output: false
 * Example 2:
 *
 * Input: [2,1,2,6]
 * Output: false
 * Example 3:
 *
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 * Example 4:
 *
 * Input: [1,2,4,16,8,4]
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 30000
 * A.length is even
 * -100000 <= A[i] <= 100000
 */
import java.util.*;
public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : A) {
            if (n == 0) continue;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0 && map.get(A[i]) > 0) {
                int target = A[i] * 2;
                if (A[i] < 0) {
                    if (A[i] % 2 != 0) return false;
                    target = A[i] / 2;
                }
                if (map.getOrDefault(target, 0) < map.get(A[i])) {
                    return false;
                }
                map.put(target, map.get(target) - map.get(A[i]));
                map.put(A[i], 0);
            }
        }
        return true;
    }

}
