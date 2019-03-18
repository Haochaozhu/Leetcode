import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1] 1 ,2 ,3
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1] 2
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 *
 * [1, 2, 2]
 */
public class ThirdMaximumNumber {

    /**
     * Sorting based solution.
     * Time complexity: O(NlgN)
     */
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int k = 0;
        for (int i = nums.length - 2; i >= 0; i -= 1) {
            if (nums[i] < nums[i + 1]) {
                k += 1;
            }
            if (k == 2) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * Use a priority queue
     */
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            if (pq.contains(n)) continue;
            pq.offer(n);
            if (pq.size() > 3) {
                pq.poll();
            }
        }
        if (pq.size() < 3) {
            if(pq.size() == 2) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
