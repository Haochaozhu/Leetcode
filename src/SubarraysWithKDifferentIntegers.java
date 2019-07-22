/**
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct)
 * subarray of A good if the number of different integers in that subarray is exactly K.
 *
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 *
 * Return the number of good subarrays of A.
 * Example 1:
 *
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2],
 * [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 *
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */
public class SubarraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        int a = atMostK(A, K);
        int b = atMostK(A, K - 1);
        System.out.println(a);
        System.out.println(b);
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    private int atMostK(int[] A, int K) {
        int n = A.length;
        int[] count = new int[n + 1];
        int l = 0;
        int distinct = 0;
        int res = 0;
        for (int r = 0; r < n; r++) {
            if (count[A[r]] == 0) distinct++;
            count[A[r]]++;
            while (distinct > K) {
                count[A[l]]--;
                if (count[A[l]] == 0) distinct--;
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
// [1,2,1,2,3]
// [1,2,1,3,4] 3
//