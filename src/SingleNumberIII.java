/**
 * Given an array of numbers nums, in which exactly two elements appear
 * only once and all the other elements appear exactly twice.
 * Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int[] ans = new int[2];
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff = Integer.highestOneBit(diff);
        for (int n : nums) {
            if ((n & diff) == 0) {
                ans[0] ^= n;
            } else {
                ans[1] ^= n;
            }
        }
        return ans;
    }
}
