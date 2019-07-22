import java.util.Arrays;

/**
 * Given an array A of positive integers (not necessarily distinct),
 * return the lexicographically largest permutation that is smaller than A,
 * that can be made with one swap (A swap exchanges the positions of two numbers A[i] and A[j]).
 * If it cannot be done, then return the same array.
 * Example 1:
 *
 * Input: [3,2,1]
 * Output: [3,1,2]
 * Explanation:
 * Swapping 2 and 1.
 * Example 2:
 *
 * Input: [1,1,5]
 * Output: [1,1,5]
 * Explanation:
 * This is already the smallest permutation.
 * Example 3:
 *
 * Input: [1,9,4,6,7]
 * Output: [1,7,4,6,9]
 * Explanation:
 * Swapping 9 and 7.
 * Example 4:
 *
 * Input: [3,1,1,3]
 * Output: [1,1,3,3]
 * Note:
 *
 * 1 <= A.length <= 10000
 * 1 <= A[i] <= 10000
 */
public class PreviousPermutationWithOneSwap {
    public int[] prevPermOpt1(int[] A) {
        String cur = "";
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                for (int j = i; j < A.length; j++) {
                    swap(A, i - 1, j);
                    if (cur.equals("")) cur = Arrays.toString(A);
                    else if (Arrays.toString(A).compareTo(cur) > 0) {
                        cur = Arrays.toString(A);
                    }
                    swap(A, i - 1, j);
                }
                break;
            }
        }
        if (cur.equals("")) return A;
        int[] ans = new int[A.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Character.getNumericValue(cur.charAt(i));
        }
        return ans;
    }
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
