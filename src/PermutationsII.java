import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(ans, new LinkedList<>(), nums, new boolean[nums.length]);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i += 1) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            temp.add(nums[i]);
            backTrack(ans, temp, nums, used);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}
