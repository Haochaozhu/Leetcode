import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume
 * the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {
    /**
     * Brute force approach using a table to store which number has appeared.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] table = new int[nums.length + 1];
        for (int i : nums) {
            table[i] += 1;
        }
        for (int i = 1; i < table.length; i += 1) {
            if (table[i] == 0) ans.add(i);
        }
        return ans;
    }

}
