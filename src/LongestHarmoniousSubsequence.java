import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 * Note: The length of the input array will not exceed 20,000.
 */
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, map.get(key + 1) + map.get(key));
            }
        }
        return maxLength;
    }

}
