import java.util.HashMap;
import java.util.Map;

/*
Given an array of integers and an integer k, you need to find
the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int currSum = 0, ans = 0;
        for (int i = 0; i < nums.length; i += 1) {
            currSum += nums[i];
            if (currSum == k) ans += 1;
            if (map.get(currSum - k) != null) {
                ans += map.get(currSum - k);
            }
            if (map.get(currSum) == null) {
                map.put(currSum, 1);
            } else map.put(currSum, map.get(currSum) + 1);
        }
        return ans;
    }

}
