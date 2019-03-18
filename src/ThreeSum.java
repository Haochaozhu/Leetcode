import java.util.*;

/*
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
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i += 1) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int complement = 0 - nums[i];
            int p = i + 1, q = nums.length - 1;
            while (p < q) {
                if (nums[p] + nums[q] == complement) {
                    ans.add(Arrays.asList(nums[i], nums[p], nums[q]));
                    p += 1;
                    q -= 1;
                    while (p < q && nums[p] == nums[p - 1]) p += 1;
                    while (p < q && nums[q] == nums[q + 1]) q -= 1;
                } else if (nums[p] + nums[q] < complement) {
                    p += 1;
                } else {
                    q -= 1;
                }
            }
        }
        return ans;
    }
}
