/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 *
 * Example:
 *
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 * Explanation:
 *
 * Initial state:
 * [0,0,0,0,0]
 *
 * After applying operation [1,3,2]:
 * [0,2,2,2,0]
 *
 * After applying operation [2,4,3]:
 * [0,2,5,5,3]
 *
 * After applying operation [0,2,-2]:
 * [-2,0,3,5,3]
 */
public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length + 1];
        for (int i = 0; i < updates.length; i++) {
            int[] cur = updates[i];
            ans[cur[0]] += cur[2];
            ans[cur[1] + 1] -= cur[2];
        }
        int[] res = new int[length];
        res[0] = ans[0];
        for (int i = 1; i < length; i++) {
            ans[i] = ans[i - 1] + ans[i];
            res[i] = ans[i];
        }
        return res;
    }


}
