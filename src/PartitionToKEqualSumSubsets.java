/**
 * Given an array of integers nums and a positive integer k,
 * find whether it's possible to divide this array into k non-empty subsets
 * whose sums are all equal.

 * Example 1:
 *
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums.
 *
 * 1, 2, 2, 3, 3, 4, 5
 *
 * Note:
 *
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0) return false;
        sum /= k;
        return canPartition(nums, k, 0, 0, sum, new boolean[nums.length]);
    }
    private boolean canPartition(int[] nums, int k, int curIndex, int curSum, int target, boolean[] visited) {
        if (k == 1) return true;
        if (curSum == target) return canPartition(nums, k - 1, 0, 0, target, visited);
        for (int i = curIndex; i < nums.length; i++) {
            if (!visited[i] && curSum + nums[i] <= target) {
                visited[i] = true;
                if (canPartition(nums, k, i + 1, curSum + nums[i], target, visited)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
