import java.util.LinkedList;
import java.util.List;

/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */
public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrack(ans, new LinkedList<>(), nums, 0);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new LinkedList<>(temp));
        for (int i = start; i < nums.length; i += 1) {
            temp.add(nums[i]);
            backTrack(ans, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
