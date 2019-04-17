import java.util.HashMap;
import java.util.Map;

/**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?

 * Example 1:
 *
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 *
 * Note:
 *
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i += 1) {
            sum += A[i];
            if (sum == S) count += 1;
            count += map.getOrDefault(S - sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
