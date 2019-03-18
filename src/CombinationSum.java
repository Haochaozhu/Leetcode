import java.util.LinkedList;
import java.util.List;
/*
Given a set of candidate numbers (candidates)
(without duplicates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrack(ans, new LinkedList<>(), target, candidates, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, LinkedList<Integer> temp, int remain, int[] nums, int start) {
        if (remain < 0) return;
        if (remain == 0) ans.add(new LinkedList<>(temp));
        else {
            for (int i = start; i < nums.length; i += 1) {
                temp.add(nums[i]);
                backTrack(ans, temp, remain - nums[i], nums, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
