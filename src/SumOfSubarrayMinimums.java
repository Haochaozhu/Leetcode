import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * 1, 2, 3, 4
 *
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */
public class SumOfSubarrayMinimums {
    final static int mod = 1000000007;
    public static int sumSubarrayMins(int[] A) {
        int sum = 0;
        int[] nextSmaller = new int[A.length];
        int[] prevSmaller = new int[A.length];
        Arrays.fill(nextSmaller, -1);
        Arrays.fill(prevSmaller, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.length; i += 1) {
            while (!st.isEmpty() && A[i] <= A[st.peek()]) {
                nextSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        st.clear();
        for (int i = A.length - 1; i >= 0; i -= 1) {
            while (!st.isEmpty() && A[i] <= A[st.peek()]) {
                prevSmaller[st.pop()] = i;
            }
            st.push(i);
        }
        for (int i = 0; i < A.length; i++) {
            int prevId = prevSmaller[i] < 0 ? 0 : prevSmaller[i] + 1;
            int nextId = nextSmaller[i] < 0 ? A.length - 1 : nextSmaller[i] - 1;
            int left = i - prevId + 1;
            int right = nextId - i + 1;
            sum += left * right * A[i];
            sum %= mod;
        }
        return sum;
    }

    public static void main(String[] args) {
        sumSubarrayMins(new int[]{3, 1, 2, 4});
    }
}
