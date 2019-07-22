import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers,
 * find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] count = new int[n];
        int[] prev = new int[n];
        int idx = -1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            prev[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                idx = i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (idx != -1) {
            ans.add(nums[idx]);
            idx = prev[idx];
        }
        return ans;
    }
}
