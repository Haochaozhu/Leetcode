import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of
 * nums, that has the same degree as nums.
 *
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;
        int minL = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            int cur = map.get(key);
            degree = Math.max(degree, cur);
        }
        if (degree == 1) return 1;
        map = new HashMap<>();
        for (int i = 0, j = 0; j < nums.length; j += 1) {
            if (!map.containsKey(nums[j])) {
                map.put(nums[j], 1);
            } else {
                map.put(nums[j], map.get(nums[j]) + 1);
                if (map.get(nums[j]) == degree) {
                    while (i < j && map.get(nums[j]) == degree) {
                        map.put(nums[i], map.get(nums[i]) - 1);
                        i += 1;
                    }
                    minL = Math.min(minL, j - i + 1);
                }
            }
        }
        return minL;
    }

}
