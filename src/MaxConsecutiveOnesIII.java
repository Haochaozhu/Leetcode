/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 *
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * Example 2:
 *
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * Output: 10
 * Explanation:
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        int start = 0, max = 0;
        int zeroCount = 0;
        for (int end = 0; end < A.length; end += 1) {
            if (A[end] == 0) {
                zeroCount += 1;
            }
            while (zeroCount > K) {
                if (A[start] == 0) zeroCount -= 1;
                start += 1;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
