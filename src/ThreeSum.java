import java.lang.reflect.Array;
import java.util.*;

/**
Given an array nums of n integers, are there elements a, b, c in
nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

array after sort: -4, -1, -1, 0, 1 ,2



A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 1) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l += 1;
                    r -= 1;
                    while (l < r && nums[l] == nums[l - 1]) l += 1;
                    while (l < r && nums[r] == nums[r + 1]) r -= 1;
                } else if (nums[l] + nums[r] < target) {
                    l += 1;
                } else r -= 1;
            }
        }
        return ans;
    }
}
