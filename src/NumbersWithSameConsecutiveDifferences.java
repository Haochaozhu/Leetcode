import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return all non-negative integers of length N such that the absolute
 * difference between every two consecutive digits is K.
 *
 * Note that every number in the answer must not have leading zeros except for the number 0
 * itself. For example, 01 has one leading zero and is invalid, but 0 is valid.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: N = 3, K = 7
 * Output: [181,292,707,818,929]
 * Explanation: Note that 070 is not a valid number, because it has leading zeroes.
 * Example 2:
 *
 * Input: N = 2, K = 1
 * Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 *
 *
 * Note:
 *
 * 1 <= N <= 9
 * 0 <= K <= 9
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> lst = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= N; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int n : lst) {
                int lastDigit = n % 10;
                if (n > 0 && lastDigit + K < 10) temp.add(n * 10 + lastDigit + K);
                if (n > 0 && lastDigit - K >= 0) temp.add(n * 10 + lastDigit - K);
            }
            lst = temp;
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) ans[i] = lst.get(i);
        return ans;
    }
}
