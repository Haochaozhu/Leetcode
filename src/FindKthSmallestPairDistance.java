import java.util.Arrays;

/**
 * Given an integer array, return the k-th smallest distance among all the pairs.
 * The distance of a pair (A, B) is defined as the absolute difference between A and B.
 *
 * Example 1:
 * Input:
 * nums = [1,3,1]
 * k = 1
 * Output: 0
 * Explanation:
 * Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Note:
 * 2 <= len(nums) <= 10000.
 * 0 <= nums[i] < 1000000.
 * 1 <= k <= len(nums) * (len(nums) - 1) / 2.
 */
public class FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int hi = nums[n - 1] - nums[0];
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            int count = countPairs(nums, mid);
            if (count < k) low = mid + 1;
            else hi = mid;
        }
        return low;
    }
    private int countPairs(int[] a, int mid) {
        int res = 0;
        for (int i = 0; i < a.length; i++) {
            int j = i;
            while (j < a.length && a[j] - a[i] <= mid) j++;
            System.out.println(j - i - 1);
            res += j - i - 1;
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
