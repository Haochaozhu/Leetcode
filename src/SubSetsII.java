import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */
public class SubSetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
        ans.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i += 1) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backTrack(ans, temp, nums, i += 1);
            temp.remove(temp.size() - 1);
        }
    }

}
