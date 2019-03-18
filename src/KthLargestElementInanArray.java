import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * 1 2 3 4 5 6
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * 1 2 2 3 3 4 5 5 6
 */
public class KthLargestElementInanArray {

    /**
     * Brute force approach using sort.
     * Time complexity: O(NlogN)
     */
    public static int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * Another approach is to use a min PriorityQueue.
     * Iterate through num, maintain k largest elements encountered so far.
     * When iteration ends, the pq.poll() will be the answer.
     * Time complexity: O(NlogK)
     * Priority queue insertion and removal operations take logN (where N is the size of the heap) in average cases.
     */
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    /**
     * Optimal solution: based on quicksort algorithm.
     * Choose a pivot, partition the array, if pivot_index == nums.length - k, then return nums[pivot_index].
     * if pivot_index < nums.length - k, check for the right part.
     * else check for the left part.
     * Time Complexity: n + (n / 2) + (n / 4) + ... + 1 = 2n - 1 = O(n)
     */
    public static int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return findKthLargest(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int findKthLargest(int[] nums, int start, int end, int k) {// quick select: kth smallest
        if (start > end) return Integer.MAX_VALUE;

        int pivot = nums[end];// Take A[end] as the pivot,
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) // Put numbers < pivot to pivot's left
                swap(nums, left++, i);
        }
        swap(nums, left, end);// Finally, swap A[end] with A[left]

        if (left == k)// Found kth smallest number
            return nums[left];
        else if (left < k)// Check right part
            return findKthLargest(nums, left + 1, end, k);
        else // Check left part
            return findKthLargest(nums, start, left - 1, k);
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest1(nums,2));
    }
}
