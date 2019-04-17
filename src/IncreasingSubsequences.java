import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
 * and the length of an increasing subsequence should be at least 2 .
 *
 * Example:
 * Input: [4, 6, 7, 7]
 * Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * Note:
 * The length of the given array will not exceed 15.
 * The range of integer in the given array is [-100,100].
 * The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
public class IncreasingSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> dumb = new HashSet<>();
        if (nums == null || nums.length == 0) return ans;
        dfs(dumb, new ArrayList<>(), 0, nums);
        ans.addAll(dumb);
        return ans;
    }

    private void dfs(Set<List<Integer>> dumb, List<Integer> temp, int start, int[] nums) {
        if (temp.size() >= 2) dumb.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i += 1) {
            if (temp.isEmpty() || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                dfs(dumb, temp, i + 1, nums);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
