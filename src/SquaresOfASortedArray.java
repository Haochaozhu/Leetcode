/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] A) {
        int i = 0;
        while (i < A.length && A[i] < 0) {
            i += 1;
        }
        int j = i;
        i -= 1;
        int[] ans = new int[A.length];
        int k = 0;
        while (j < A.length || i >= 0) {
            if (j >= A.length) {
                ans[k++] = A[i] * A[i];
                i -= 1;
            } else if (i < 0) {
                ans[k++] = A[j] * A[j];
                j += 1;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[k++] = A[i];
                i -= 1;
            } else {
                ans[k++] = A[j];
                j += 1;
            }
        }
        return ans;
    }

}
