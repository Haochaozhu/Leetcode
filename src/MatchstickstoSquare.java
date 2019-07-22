import java.util.Arrays;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 *
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 *
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 *
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 *
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */

public class MatchstickstoSquare {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int n = nums.length;
        int sum = 0;
        for (int k : nums) sum += k;
        if (sum % 4 != 0) return false;
        sum /= 4;
        return dfs(0, sum, 0, 4, nums, new boolean[n]);
    }
    private boolean dfs(int idx, int target, int curSum, int need, int[] nums, boolean[] used) {
        if (need == 0) return true;
        if (curSum == target) return dfs(0, target, 0, need - 1, nums, used);
        else {
            for (int i = idx; i < nums.length; i++) {
                if (!used[i] && nums[i] + curSum <= target) {
                    used[i] = true;
                    if (dfs(i + 1, target, curSum + nums[i], need, nums, used)) return true;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
