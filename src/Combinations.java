import java.util.LinkedList;
import java.util.List;

/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        backTrack(ans, new LinkedList<>(), k, n, 1);
        return ans;
    }
    private void backTrack(List<List<Integer>> ans, List<Integer> temp, int length, int max, int start) {
        if (temp.size() == length) {
            ans.add(new LinkedList<>(temp));
            return;
        }
        for (int i = start; i <= max; i += 1) {
            temp.add(i);
            backTrack(ans, temp, length, max, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
