/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
Follow up:

This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
Would this affect the run-time complexity? How and why?

 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > nums[lo]) { // left array is sorted, search left array.
                if (target < nums[mid] && target >= nums[lo]) hi = mid;
                else lo = mid + 1;
            } else if (nums[mid] < nums[lo]) { // right array is sorted, search right array.
                if (target > nums[mid] && target < nums[lo]) lo = mid + 1;
                else hi = mid;
            } else lo += 1;
        }
        return false;
    }
}
