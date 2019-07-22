import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * We have a set of items: the i-th item has value values[i] and label labels[i].
 *
 * Then, we choose a subset S of these items, such that:
 *
 * |S| <= num_wanted
 * For every label L, the number of items in S with label L is <= use_limit.
 * Return the largest possible sum of the subset S.
 *
 *
 *
 * Example 1:
 *
 * Input: values = [5,4,3,2,1], labels = [1,1,2,2,3], num_wanted = 3, use_limit = 1
 * Output: 9
 * Explanation: The subset chosen is the first, third, and fifth item.
 * Example 2:
 *
 * Input: values = [5,4,3,2,1], labels = [1,3,3,3,2], num_wanted = 3, use_limit = 2
 * Output: 12
 * Explanation: The subset chosen is the first, second, and third item.
 * Example 3:
 *
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 1
 * Output: 16
 * Explanation: The subset chosen is the first and fourth item.
 * Example 4:
 *
 * Input: values = [9,8,8,7,6], labels = [0,0,0,1,1], num_wanted = 3, use_limit = 2
 * Output: 24
 * Explanation: The subset chosen is the first, second, and fourth item.
 *
 *
 * Note:
 *
 * 1 <= values.length == labels.length <= 20000
 * 0 <= values[i], labels[i] <= 20000
 * 1 <= num_wanted, use_limit <= values.length
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int n = values.length;
        int[][] table = new int[n][2];
        for (int i = 0; i < n; i++) {
            table[i][0] = values[i];
            table[i][1] = labels[i];
        }
        Arrays.sort(table, (o1, o2) -> o2[0] - o1[0]);
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(table[i][1], 0) < use_limit && count < num_wanted) {
                map.put(table[i][1], map.getOrDefault(table[i][1], 0) + 1);
                sum += table[i][0];
                count++;
            }
        }
        return sum;
    }
}
