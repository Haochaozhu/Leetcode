import java.util.LinkedList;
import java.util.List;
/*
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrack(ans, new LinkedList<>(), nums);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i += 1) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backTrack(ans, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
