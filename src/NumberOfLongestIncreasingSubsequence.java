import java.util.Arrays;

/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * Note: Length of the given array will be not exceed 2000 and the answer is guaranteed to be fit in 32-bit signed int.
 */
public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int res = 0, max = 0;
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i += 1) {
            length[i] = count[i] = 1;
            for (int j = 0; j < i; j += 1) if (nums[i] > nums[j]) {
                if (length[j] + 1 > length[i]) {
                    length[i] = length[j] + 1;
                    count[i] = count[j];
                } else if (length[j] + 1 == length[i]) count[i] += count[j];
            }
            if (max == length[i]) res += count[i];
            else if (max < length[i]) {
                max = length[i];
                res = count[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] test = {1,3,5,4,7};
        findNumberOfLIS(test);
    }
}
/**
 1   3   5   4   7
 1   2   3   3   4
 1   1   1   1   2

 **/