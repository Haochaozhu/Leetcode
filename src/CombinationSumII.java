import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of candidate numbers (candidates) and a target number
(target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]

1 2 2 2 5

 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(ans, new LinkedList<>(), target, candidates, 0);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, LinkedList<Integer> temp, int remain, int[] nums, int start) {
        if (remain < 0) return;
        if (remain == 0) ans.add(new LinkedList<>(temp));
        else {
            for (int i = start; i < nums.length; i += 1) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                temp.add(nums[i]);
                backTrack(ans, temp, remain - nums[i], nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

}
