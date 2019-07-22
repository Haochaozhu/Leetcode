import java.util.*;
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 3) return ans;
        backtrack(ans, new ArrayList<>(), n, 2);
        return ans;
    }
    private void backtrack(List<List<Integer>> ans, List<Integer> temp, int n, int start) {
        if (n == 1) {
            if (temp.size() > 1) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i != 0) continue;
            temp.add(i);
            backtrack(ans, temp, n / i, i);
            temp.remove(temp.size() - 1);
        }
    }
}
