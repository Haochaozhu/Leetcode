import java.util.LinkedList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination
 * should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new LinkedList<>();
        if (k > n) return ans;
        backtrack(ans, k, 0, n, new LinkedList<>(), 0);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, int k, int curSum,
                           int target, List<Integer> temp, int start) {
        if (temp.size() == k) {
            if (curSum == target) {
                ans.add(new LinkedList<>(temp));
            }
            return;
        }
        for (int i = start + 1; i <= 9; i += 1) {
            temp.add(i);
            curSum += i;
            backtrack(ans, k, curSum, target, temp, i);
            curSum -= i;
            temp.remove(temp.size() - 1);
        }
    }
}
